package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

/**
 * Autor: Sandro Guevara
 * Objetivo: Clase de dominio que representa un Catalogo Basico 
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class Catalogo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String value;
	
	public Catalogo() {

	}
	public Catalogo(String name, String value) {
		super();
		this.id = name;
		this.value = value;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	};
	
	

}
