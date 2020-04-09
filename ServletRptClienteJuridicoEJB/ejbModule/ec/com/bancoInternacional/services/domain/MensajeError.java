package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

/**
 * Autor: Sandro Guevara
 * Objetivo:	Clase que representa un error enviado desde Programas de Servicio
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class MensajeError  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private boolean isError;
	private String errorMessage;
	
	
	public MensajeError(String errorCode, boolean isError, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.isError = isError;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
