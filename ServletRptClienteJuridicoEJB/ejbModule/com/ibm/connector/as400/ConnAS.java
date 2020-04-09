package com.ibm.connector.as400;

import iseries.programcall.base.AbstractProgramCallBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400ConnectionPool;

import ec.com.bancoInternacional.AesUtil.desencripador.Desencriptador;
import ec.com.bancoInternacional.config.Application;
/**
 * Autor:		Carlos Carrera, migrado de aplicacion de clientes gwt
 * Objetivo:	Clase que gestiona el pool de conexiones hacia AS/400
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class ConnAS {
	
	private static final Logger logger = Logger.getLogger(ConnAS.class);
	private static String usuario = null;
	private static String clave = null;
	private static String servidor = null;
	private static int maxConec = 0;
	private static int maxTiemVida = 0;
	private static int maxTiemInac = 0;
	private static int tiemCleanup = 0;
	private static int connPre = 0;
	private static int maxNumThreads = 0;
	private static AS400ConnectionPool poolConnAS = null;
	private static ExecutorService EXECUTOR = null;//thread pool
	public static List<String> listaParametros = null;

	static {		
		
		listaParametros = new ArrayList<String>();

		listaParametros.addAll(
				Desencriptador.obtenerDatos(
						Application.getString("path.archivos.as400") + Application.getString("archivo.as400.enc"), 
						Application.getString("path.archivos.as400") + Application.getString("archivo.as400.key"), 
						Application.getString("path.archivos.as400") + Application.getString("archivo.as400.seed")));
		if (listaParametros != null && listaParametros.size() > 0) {			
			usuario = listaParametros.get(0);
			clave = listaParametros.get(1);
		}
		
		servidor = Application.getString("app.i5Series.srv");
		maxConec = Integer.parseInt(Application.getString("pool.max.num"));
		maxTiemVida = Integer.parseInt(Application.getString("pool.max.time.life"));
		maxTiemInac = Integer.parseInt(Application.getString("pool.max.time.inactive"));
		tiemCleanup = Integer.parseInt(Application.getString("pool.cleanup.time"));
		connPre = Integer.parseInt(Application.getString("pool.conn.pre"));
		poolConnAS = new AS400ConnectionPool();
		
		
		logger.debug("Inicia Pool Conexiones ...");

		try {
			// Establece el máximo número de conexiones para este pool.
			poolConnAS.setMaxConnections(maxConec);

			// Establece el tiempo de vida máximo para la conexión.
			poolConnAS.setMaxLifetime(maxTiemVida);
			
			// Establece el tiempo máximo de inactividad para la conexión
			poolConnAS.setMaxInactivity(maxTiemInac);
			
			// Establece el tiempo de intervalo en el que se pool para eliminar conexiones expiradas
			poolConnAS.setCleanupInterval(tiemCleanup);
			
			// Preconectar conexiones al servicio AS400.COMMAND.
			poolConnAS.fill(servidor, usuario, clave, AS400.COMMAND, connPre);

			logger.debug("Preconectadas ".concat(String.valueOf(connPre)).concat(" conexiones al servicio AS400.COMMAND"));

			logger.debug("Cantidad de conexiones activas: ".concat(String.valueOf(
					poolConnAS.getActiveConnectionCount(servidor, usuario))));
			logger.debug("Cantidad de conexiones activas para usar: ".concat(String.valueOf(
					poolConnAS.getAvailableConnectionCount(servidor, usuario))));

		} catch (Exception e) {
			logger.error("Operaciones de pool con falla ".concat(e.toString()));
//			e.printStackTrace();
		}
		
		maxNumThreads = Integer.parseInt(Application.getString("thread.pool.max"));
		
		logger.debug("Inicia Pool Threads ...");
		
		// se instancia con un número máximo de hilos que se ejecutarán simultánemente
		EXECUTOR = Executors.newFixedThreadPool(maxNumThreads);
	}//static
	
/**
 * Método que realiza el manejo de conexiones con el pool y la desconexión del comando
 * @param pCallBean instancia del programa de servicio a invocar  
 */
	public ProgramCallBean conectaAS400(ProgramCallBean pCallBean) {

		AS400 conn = null;
		String nombrePrograma = null;

		try {
			nombrePrograma = pCallBean.getProgramName();
			conn = poolConnAS.getConnection(servidor, usuario, clave,AS400.COMMAND);
			pCallBean.setConnectionData(conn);

			logger.debug("Programa : ".concat(nombrePrograma));
			logger.debug("Cantidad de conexiones activas: ".concat(String.valueOf(
					poolConnAS.getActiveConnectionCount(servidor, usuario))));

			pCallBean.invoke();

//			pCallBean.disconnect();

			poolConnAS.returnConnectionToPool(conn);

			logger.debug("Conexion retornada al pool");
			logger.debug("Cantidad de conexiones activas para usarse: ".concat(String.valueOf(
					 poolConnAS.getAvailableConnectionCount(servidor, usuario))));

			logger.debug("Programa : ".concat(nombrePrograma));

		} catch (Exception e) {
			logger.error("Error al ejecutar el programa: ".concat(nombrePrograma), e);
//			e.printStackTrace();
		}
		
		conn = null;
		nombrePrograma = null;
		
		return pCallBean;
	}//conectaAS400
	
	/**
	 * Método que realiza el manejo de conexiones con el pool y la desconexión del comando
	 * @param pCallBean instancia del programa de servicio a invocar  
	 */
		public AbstractProgramCallBean conectaAS400(AbstractProgramCallBean pCallBean) {

			AS400 conn = null;
			String nombrePrograma = null;

			try {
				nombrePrograma = pCallBean.getClass().toString();
				conn = poolConnAS.getConnection(servidor, usuario, clave,AS400.COMMAND);
//				pCallBean.setConnectionData(conn);
				
				iseries.programcall.base.AS400Connection as400Connection = new iseries.programcall.base.AS400Connection(conn);
				pCallBean.initConnection(as400Connection);

				logger.debug("Programa : ".concat(nombrePrograma));
				logger.debug("Cantidad de conexiones activas: ".concat(String.valueOf(
						poolConnAS.getActiveConnectionCount(servidor, usuario))));

				pCallBean.invoke();

				poolConnAS.returnConnectionToPool(conn);

				logger.debug("Conexion retornada al pool");
				logger.debug("Cantidad de conexiones activas para usarse: ".concat(String.valueOf(
						 poolConnAS.getAvailableConnectionCount(servidor, usuario))));

				logger.debug("Programa : ".concat(nombrePrograma));

			} catch (Exception e) {
				logger.error("Error al ejecutar el programa: ".concat(nombrePrograma), e);
//				e.printStackTrace();
			}
			
			conn = null;
			nombrePrograma = null;
			
			return pCallBean;
		}//conectaAS400
	
	/**
	 * Somete un thread en un pool y devuelve un objeto para acceder al resultado.
	 * @param callable tipo de thread que permite retornar un resultado
	 * @return Future permite acceder al resultado de la ejecución del thread
	 */
	public static Future<ProgramCallBean> someterThread(Callable<ProgramCallBean> callable){
		return EXECUTOR.submit(callable);//ejecuta el thread en un pool
	}
	
	/**
	 * Somete un thread en un pool y devuelve un objeto para acceder al resultado.
	 * @param callable tipo de thread que permite retornar un resultado
	 * @return Future permite acceder al resultado de la ejecución del thread
	 */
	public static Future<AbstractProgramCallBean> someterThreadNpcb(Callable<AbstractProgramCallBean> callable){
		return EXECUTOR.submit(callable);//ejecuta el thread en un pool
	}
	
	/**
	 * Finaliza los pools de threads y conexiones para liberar recursos.
	 */
	public static void finaliza(){
		if(null!=EXECUTOR){
			logger.debug("Fin threadPool ...");
			EXECUTOR.shutdown();
			EXECUTOR = null;
		}
		if(null!=poolConnAS){
			logger.debug("Fin connectionPool ...");
			poolConnAS.close();
			poolConnAS = null;
		}
	}//finaliza

}//fin de la clase
