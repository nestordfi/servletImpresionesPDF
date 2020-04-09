package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;

/**
 * Autor:		Kiriakos Boulioudis
 * Objetivo:	Objecto de datos default de catalogos de cantones
 * Fecha:		02-01-2018
 * Nro. Req:	1546
 * Version:		1.0
 */
public class CatalogoModeloVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	private String ciudad;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return id.concat("|").concat(name);
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}	
	
	
	
}
