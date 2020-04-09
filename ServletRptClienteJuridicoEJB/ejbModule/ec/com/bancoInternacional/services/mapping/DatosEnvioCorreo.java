package ec.com.bancoInternacional.services.mapping;

import java.math.BigDecimal;

/**
 *	Clase que contendra la informacion que retorna el servicio de as400
 *	jar cs0133.  
 */
public class DatosEnvioCorreo {
	
	private String estadoCorreo;
	private String nombreAsesor;
	private BigDecimal numeroTelefonoAsesor;
	private String nombreAgencia;
	
	public String getEstadoCorreo() {
		return estadoCorreo;
	}
	
	public void setEstadoCorreo(String estadoCorreo) {
		this.estadoCorreo = estadoCorreo;
	}
	
	public String getNombreAsesor() {
		return nombreAsesor;
	}
	
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}
	
	public BigDecimal getNumeroTelefonoAsesor() {
		return numeroTelefonoAsesor;
	}
	
	public void setNumeroTelefonoAsesor(BigDecimal numeroTelefonoAsesor) {
		this.numeroTelefonoAsesor = numeroTelefonoAsesor;
	}
	
	public String getNombreAgencia() {
		return nombreAgencia;
	}
	
	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}
}