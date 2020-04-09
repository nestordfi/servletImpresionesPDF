package ec.com.bancoInternacional.ConsultaBastanteo.modelo;



import java.io.Serializable;

/**
 * Autor: Nestor Franco Objetivo: Objeto para vista - Seccion Identificacion
 * Fecha: 03-07-2018 Nro. Req: 1 Version: 1.0
 */
public class IdentificacionSeccionVO implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	// pantalla
	
	private String cmbTipoIdentificacion;
	private String txtIdentificacion;
	private String txtRazonSocial;
	private String txtCodigoCliente;

	public String getCmbTipoIdentificacion() {
		cmbTipoIdentificacion = cmbTipoIdentificacion == null ? new String() : cmbTipoIdentificacion.toUpperCase();
		return cmbTipoIdentificacion;
	}

	public void setCmbTipoIdentificacion(String cmbTipoIdentificacion) {
		this.cmbTipoIdentificacion = cmbTipoIdentificacion;
	}

	public String getTxtIdentificacion() {
		txtIdentificacion = txtIdentificacion == null ? new String() : txtIdentificacion.toUpperCase();
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(String txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public String getTxtRazonSocial() {
		txtRazonSocial = txtRazonSocial == null ? new String() : txtRazonSocial.toUpperCase();
		return txtRazonSocial;
	}

	public void setTxtRazonSocial(String txtRazonSocial) {
		this.txtRazonSocial = txtRazonSocial;
	}

	public String getTxtCodigoCliente() {
		txtCodigoCliente = txtCodigoCliente == null ? new String() : txtCodigoCliente.toUpperCase();
		return txtCodigoCliente;
	}

	public void setTxtCodigoCliente(String txtCodigoCliente) {
		this.txtCodigoCliente = txtCodigoCliente;
	}

}
