package ec.com.bancoInternacional.services.ibm.pool;

import iseries.programcall.base.AbstractProgramCallBean;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ibm.as400.access.ExtendedIllegalArgumentException;
import com.ibm.connector.as400.ConnAS;
/**
 * Autor:		Carlos Carrera, migrada de clientes gwt
 * Objetivo:	Retorna el callbean después de la ejecución del thread correspondiente en un pool.
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class TareaNpcb implements Callable<AbstractProgramCallBean> {
	private AbstractProgramCallBean pCallBean = null;

	public TareaNpcb(AbstractProgramCallBean callBean) {
		super();
		pCallBean = callBean;
	}

	public AbstractProgramCallBean call() throws Exception {
		//instrucciones ejecutadas en el thread
		ConnAS connAS = new ConnAS();
		AbstractProgramCallBean aCallBean = connAS.conectaAS400(pCallBean);
		connAS = null;
		return aCallBean;
	}//call
	
	/**
	 * Ejecuta el thread en un pool, espera el resutado y lo retorna.
	 * @return AbstractProgramCallBean aCallBean
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public AbstractProgramCallBean invoca() throws InterruptedException, ExecutionException {
		Future<AbstractProgramCallBean> future = ConnAS.someterThreadNpcb(this);
		AbstractProgramCallBean aCallBean = (AbstractProgramCallBean)future.get();//espera el resultado del proceso
		future = null;
		return aCallBean;
	}//invoca

}//fin de la clase
