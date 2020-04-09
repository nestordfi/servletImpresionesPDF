package ec.com.bancoInternacional.services.exception;

import java.util.ArrayList;
import java.util.List;

import ec.com.bancoInternacional.services.domain.ErrorValidacion;

/**
 * Autor:		Kiriakos Boulioudis
 * Objetivo:	Objecto de excepcion en la validacion de secciones de AS400
 * Fecha:		05-01-2018
 * Nro. Req:	1546
 * Version:		1.0
 */
public class AS400ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ErrorValidacion> errorList;

	public AS400ValidationException(String message) {
		super(message);
	}

	public AS400ValidationException(List<ErrorValidacion> errorList) {
		super();
	}

	public List<ErrorValidacion> getErrorList() {
		if(errorList==null)
			return new ArrayList<ErrorValidacion>();
			
		return errorList;
	}

	public void setErrorList(List<ErrorValidacion> errorList) {
		this.errorList = errorList;
	}
	
	
}
