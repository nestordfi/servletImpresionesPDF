package ec.com.bancoInternacional.services.domain;

public class InformacionTributacionExterior {
	private String identificacionRelacionada;
	private String secuencial;
	private String paisTributacion;
	private String estadoTributacion;
	private String ciudadTributacion;
	private String tipoIdentificacion;
	private String identificacion;
	private String calle;
	private String numeroCasa;
	private String numeroOficina;
	private String piso;
	private String barrio;
	private String codigoPostal;
	private String oficinaPostal;
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getIdentificacionRelacionada() {
		return identificacionRelacionada;
	}
	public void setIdentificacionRelacionada(String identificacionRelacionada) {
		this.identificacionRelacionada = identificacionRelacionada;
	}
	public String getSecuencial() {
		return secuencial;
	}
	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}
	public String getPaisTributacion() {
		return paisTributacion;
	}
	public void setPaisTributacion(String paisTributacion) {
		this.paisTributacion = paisTributacion;
	}
	public String getEstadoTributacion() {
		return estadoTributacion;
	}
	public void setEstadoTributacion(String estadoTributacion) {
		this.estadoTributacion = estadoTributacion;
	}
	public String getCiudadTributacion() {
		return ciudadTributacion;
	}
	public void setCiudadTributacion(String ciudadTributacion) {
		this.ciudadTributacion = ciudadTributacion;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getNumeroOficina() {
		return numeroOficina;
	}
	public void setNumeroOficina(String numeroOficina) {
		this.numeroOficina = numeroOficina;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getOficinaPostal() {
		return oficinaPostal;
	}
	public void setOficinaPostal(String oficinaPostal) {
		this.oficinaPostal = oficinaPostal;
	}
	@Override
	public String toString() {
		return "InformacionTributacionExterior [identificacionRelacionada=" + identificacionRelacionada
				+ ", secuencial=" + secuencial + ", paisTributacion=" + paisTributacion + ", estadoTributacion="
				+ estadoTributacion + ", ciudadTributacion=" + ciudadTributacion + ", tipoIdentificacion="
				+ tipoIdentificacion + ", identificacion=" + identificacion + ", calle=" + calle + ", numeroCasa="
				+ numeroCasa + ", numeroOficina=" + numeroOficina + ", piso=" + piso + ", barrio=" + barrio
				+ ", codigoPostal=" + codigoPostal + ", oficinaPostal=" + oficinaPostal + "]";
	}
	
}
