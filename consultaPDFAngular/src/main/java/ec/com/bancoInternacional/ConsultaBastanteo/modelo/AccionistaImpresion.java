package ec.com.bancoInternacional.ConsultaBastanteo.modelo;


/**
 * Autor:		Nestor Franco
 * Objetivo:	Objeto para impresion - Seccion Accionistas
 * Fecha:		16-07-2018
 * Nro. Req:	1
 * Version:		1.0
 */
public class AccionistaImpresion {

	private String naturalJuridicoAccionistas;
	private String identificacionAccionistas;
	private String nombreRazonSocialAccionistas;
	private String porcentajeAccionistas;
	private String montoAccionistas;
	private String nacionalidadAccionistas;
	private String tipoIdentificacionAccionistas;
	private String indexAccionistas;
	public String getNaturalJuridicoAccionistas() {
		return naturalJuridicoAccionistas;
	}
	public void setNaturalJuridicoAccionistas(String naturalJuridicoAccionistas) {
		this.naturalJuridicoAccionistas = naturalJuridicoAccionistas;
	}
	public String getIdentificacionAccionistas() {
		return identificacionAccionistas;
	}
	public void setIdentificacionAccionistas(String identificacionAccionistas) {
		this.identificacionAccionistas = identificacionAccionistas;
	}
	public String getPorcentajeAccionistas() {
		return porcentajeAccionistas;
	}
	public void setPorcentajeAccionistas(String porcentajeAccionistas) {
		this.porcentajeAccionistas = porcentajeAccionistas;
	}
	public String getMontoAccionistas() {
		return montoAccionistas;
	}
	public void setMontoAccionistas(String montoAccionistas) {
		this.montoAccionistas = montoAccionistas;
	}
	public String getNacionalidadAccionistas() {
		return nacionalidadAccionistas;
	}
	public void setNacionalidadAccionistas(String nacionalidadAccionistas) {
		this.nacionalidadAccionistas = nacionalidadAccionistas;
	}
	public String getTipoIdentificacionAccionistas() {
		return tipoIdentificacionAccionistas;
	}
	public void setTipoIdentificacionAccionistas(String tipoIdentificacionAccionistas) {
		this.tipoIdentificacionAccionistas = tipoIdentificacionAccionistas;
	}
	public String getIndexAccionistas() {
		return indexAccionistas;
	}
	public void setIndexAccionistas(String indexAccionistas) {
		this.indexAccionistas = indexAccionistas;
	}
	public String getNombreRazonSocialAccionistas() {
		return nombreRazonSocialAccionistas;
	}
	public void setNombreRazonSocialAccionistas(String nombreRazonSocialAccionistas) {
		this.nombreRazonSocialAccionistas = nombreRazonSocialAccionistas;
	}
	@Override
	public String toString() {
		return "AccionistaImpresion [naturalJuridicoAccionistas=" + naturalJuridicoAccionistas
				+ ", identificacionAccionistas=" + identificacionAccionistas + ", nombreRazonSocialAccionistas="
				+ nombreRazonSocialAccionistas + ", porcentajeAccionistas=" + porcentajeAccionistas
				+ ", montoAccionistas=" + montoAccionistas + ", nacionalidadAccionistas=" + nacionalidadAccionistas
				+ ", tipoIdentificacionAccionistas=" + tipoIdentificacionAccionistas + ", indexAccionistas="
				+ indexAccionistas + "]";
	}	
}
