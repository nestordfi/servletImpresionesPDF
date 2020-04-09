package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

import ec.com.bancoInternacional.cs0122.__INP_RCNTRBRN;

/**
 * Autor: Sandro Guevara
 * Objetivo: Objecto de datos de la seccion de Información de la oficina
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class OficinaInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int status;
	private __INP_RCNTRBRN retorna = new __INP_RCNTRBRN();
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public __INP_RCNTRBRN getRetorna() {
		return retorna;
	}
	public void setRetorna(__INP_RCNTRBRN retorna) {
		this.retorna = retorna;
	}

}
