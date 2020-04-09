package ec.com.bancoInternacional.services.domain;

/**
 * Autor:		Kiriakos Boulioudis
 * Objetivo:	Objecto de errores de la validacion de scciones del cliente en la parte del servicios
 * Fecha:		28-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class ErrorValidacion {
	
	private String field;
	private String code;
	private String details;
	private String type;
	
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isError() {
		return getCode() != null && !"".equals(getCode()) && !"0".equals(getCode());
	}

}
