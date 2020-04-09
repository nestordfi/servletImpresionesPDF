package ec.com.bancoInternacional.ConsultaBastanteo.modelo;


import java.io.Serializable;

/**
 * Autor:		Carlos Carrera
 * Objetivo:	Clase de dominio que representa un Catalogo Basico
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class Cargo extends Catalogo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoCargo; //I - independiente; D - dependiente
	private String estado; // Solo A para catalogo interno
	public String getTipoCargo() {
		return tipoCargo;
	}
	public void setTipoCargo(String tipoCargo) {
		this.tipoCargo = tipoCargo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cargo [tipoCargo=" + tipoCargo + ", estado=" + estado + "]";
	}
}
