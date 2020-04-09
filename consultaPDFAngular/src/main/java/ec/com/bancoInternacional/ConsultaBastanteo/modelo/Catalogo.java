package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;

/**
 * Autor:		Carlos Carrera
 * Objetivo:	Clase de dominio que representa un Catalogo Basico
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
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
	}
	
	@Override
	public String toString() {
		return "Catalogo [id=" + id + ", value=" + value + "]";
	};
}
