package ec.com.bancoInternacional.services.ibm.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ibm.connector.as400.ConnAS;
import com.ibm.connector.as400.ProgramCallBean;
/**
 * Autor:		Carlos Carrera, migrada de clientes gwt
 * Objetivo:	Retorna el callbean después de la ejecución del thread correspondiente en un pool.
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class Tarea implements Callable<ProgramCallBean> {
	private ProgramCallBean pCallBean = null;

	public Tarea(ProgramCallBean callBean) {
		super();
		pCallBean = callBean;
	}

	public ProgramCallBean call() throws Exception {
		//instrucciones ejecutadas en el thread
		ConnAS connAS = new ConnAS();
		ProgramCallBean aCallBean = connAS.conectaAS400(pCallBean);
		connAS = null;
		return aCallBean;
	}//call
	
	/**
	 * Ejecuta el thread en un pool, espera el resutado y lo retorna.
	 * @return ProgramCallBean aCallBean
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public ProgramCallBean invoca() throws InterruptedException, ExecutionException {
		Future<ProgramCallBean> future = ConnAS.someterThread(this);
		ProgramCallBean aCallBean = (ProgramCallBean)future.get();//espera el resultado del proceso
		future = null;
		return aCallBean;
	}//invoca

}//fin de la clase
