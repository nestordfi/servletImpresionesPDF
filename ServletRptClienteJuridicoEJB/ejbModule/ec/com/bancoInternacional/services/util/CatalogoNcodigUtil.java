package ec.com.bancoInternacional.services.util;


import java.io.Serializable;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.services.domain.MensajeError;
import ec.com.bancoInternacional.services.ibm.pool.PooledTrx;

/**
 * Autor: Sandro Guevara
 * Objetivo:	Clase Utilitaria para catalogo Ncodig
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class CatalogoNcodigUtil extends PooledTrx  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CatalogoNcodigUtil.class);

	

	public String getStrErrores(final String[] trxoerror) {
		// TODO migrar logica para errores
		return null;
	}

	
	public String buildErrorMessage(final ConsultaNcodigParametro parameterObject, final String errors) {

		StringBuilder errorMessage = new StringBuilder(parameterObject.getTabla());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getNivel());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod1());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod2());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod3());
		errorMessage.append(";");
		errorMessage.append(parameterObject.getCod4());
		errorMessage.append(":");
		errorMessage.append(errors);
		return errorMessage.toString();
	}

	
	
	
	public MensajeError getErrors(){
		return null;
	}
}
