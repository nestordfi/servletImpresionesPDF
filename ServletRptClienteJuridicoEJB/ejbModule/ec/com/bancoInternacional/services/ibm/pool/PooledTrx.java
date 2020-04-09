package ec.com.bancoInternacional.services.ibm.pool;

import java.util.concurrent.ExecutionException;

import com.ibm.connector.as400.ProgramCallBean;

import iseries.programcall.base.AbstractProgramCallBean;

/**
 * Autor:		Carlos Carrera, migrada de clientes gwt
 * Objetivo:	Clase para invocacion de programas de servicio de AS/400
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class PooledTrx {
	
	/**
	 * Somete la ejecución del ProgramCallBean en un thread pool, se ejecuta tomando una conexión de un pool hacia el AS/400.
	 * @param callBean
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public void invokeTrx(ProgramCallBean callBean) throws InterruptedException, ExecutionException{
		Tarea tarea = new Tarea(callBean);
		callBean = tarea.invoca();
		tarea = null;
	}//invokeTrx
	
	/**
	 * Somete la ejecución del ProgramCallBean en un thread pool, se ejecuta tomando una conexión de un pool hacia el AS/400.
	 * @param callBean
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public void invokeTrx(AbstractProgramCallBean callBean) throws InterruptedException, ExecutionException{
		TareaNpcb tarea = new TareaNpcb(callBean);
		callBean = tarea.invoca();
		tarea = null;
	}//invokeTrx	

}//fin de la clase