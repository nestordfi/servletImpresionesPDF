package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.math.BigDecimal;

public class FuncionarioResponsable {
	private String id;
	private String nombre;
	private String cargo;
	private BigDecimal agencia;
	
	public BigDecimal getAgencia() {
		return agencia;
	}
	public void setAgencia(BigDecimal agencia) {
		this.agencia = agencia;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "FuncionarioResponsable [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + ", agencia=" + agencia
				+ "]";
	}
}
