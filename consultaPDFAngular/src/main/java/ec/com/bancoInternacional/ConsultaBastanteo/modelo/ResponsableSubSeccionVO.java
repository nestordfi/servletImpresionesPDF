package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.util.Date;

public class ResponsableSubSeccionVO implements Serializable {

	private Date dteFechaActualizacion;
	private String cmbCargoResponsable;
	private String cmbNombreResponsable;
	private String cmbEjecutivoPrincipal;
	private static final long serialVersionUID = 1L;

	public Date getDteFechaActualizacion() {
		return dteFechaActualizacion;
	}

	public void setDteFechaActualizacion(Date dteFechaActualizacion) {
		this.dteFechaActualizacion = dteFechaActualizacion;
	}

	public String getCmbCargoResponsable() {
		cmbCargoResponsable = cmbCargoResponsable == null ? new String() : cmbCargoResponsable.toUpperCase();
		return cmbCargoResponsable;
	}

	public void setCmbCargoResponsable(String cmbCargoResponsable) {
		this.cmbCargoResponsable = cmbCargoResponsable;
	}

	public String getCmbNombreResponsable() {
		cmbNombreResponsable = cmbNombreResponsable == null ? new String() : cmbNombreResponsable.toUpperCase();
		return cmbNombreResponsable;
	}

	public void setCmbNombreResponsable(String cmbNombreResponsable) {
		this.cmbNombreResponsable = cmbNombreResponsable;
	}

	public String getCmbEjecutivoPrincipal() {
		cmbEjecutivoPrincipal = cmbEjecutivoPrincipal == null ? new String() : cmbEjecutivoPrincipal.toUpperCase();
		return cmbEjecutivoPrincipal;
	}
	
	public void setCmbEjecutivoPrincipal(String cmbEjecutivoPrincipal) {
		this.cmbEjecutivoPrincipal = cmbEjecutivoPrincipal;
	}

}
