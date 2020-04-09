package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;
import java.util.List;

public class DatosJuridicoDto implements Serializable{
	private static final long serialVersionUID = 7652460779577848043L;
	
	private Identificacion objIdentificacion;
	private InfBasica objInfBasica;
	private InfFinanciera objInfFinanciera;
	private FormularioFatca objFormularioFatca;
	private InfContactoUbicacion obInfContactoUbicacion;
	private InfContactoTelefonoCorreo objInfContactoTelefono;	
	private InfReferenciaPersonaContacto objInfReferenciaPersonaContacto;
	private InfReferenciaPrincipalCliente objInfReferenciaPrincipalCliente;
	private InfReferenciaPersonaProveedor objInfReferenciaPersonaProveedor;
	private InfTransaccionesExterior objInfTransaccionesExterior;
	
	private List<RepresentanteLegal> lstRepresentanteLegal;
	private List<Accionista> lstAccionista; // dentro se encuentra beneficiarios
	
	private String error;
	
	public DatosJuridicoDto() {
		super();
	}

	public Identificacion getObjIdentificacion() {
		return objIdentificacion;
	}

	public void setObjIdentificacion(Identificacion objIdentificacion) {
		this.objIdentificacion = objIdentificacion;
	}

	public InfBasica getObjInfBasica() {
		return objInfBasica;
	}

	public void setObjInfBasica(InfBasica objInfBasica) {
		this.objInfBasica = objInfBasica;
	}

	public InfFinanciera getObjInfFinanciera() {
		return objInfFinanciera;
	}

	public void setObjInfFinanciera(InfFinanciera objInfFinanciera) {
		this.objInfFinanciera = objInfFinanciera;
	}

	public FormularioFatca getObjFormularioFatca() {
		return objFormularioFatca;
	}

	public void setObjFormularioFatca(FormularioFatca objFormularioFatca) {
		this.objFormularioFatca = objFormularioFatca;
	}

	public InfContactoUbicacion getObInfContactoUbicacion() {
		return obInfContactoUbicacion;
	}

	public void setObInfContactoUbicacion(InfContactoUbicacion obInfContactoUbicacion) {
		this.obInfContactoUbicacion = obInfContactoUbicacion;
	}

	public InfContactoTelefonoCorreo getObjInfContactoTelefono() {
		return objInfContactoTelefono;
	}

	public void setObjInfContactoTelefono(InfContactoTelefonoCorreo objInfContactoTelefono) {
		this.objInfContactoTelefono = objInfContactoTelefono;
	}

	public InfReferenciaPersonaContacto getObjInfReferenciaPersonaContacto() {
		return objInfReferenciaPersonaContacto;
	}

	public void setObjInfReferenciaPersonaContacto(InfReferenciaPersonaContacto objInfReferenciaPersonaContacto) {
		this.objInfReferenciaPersonaContacto = objInfReferenciaPersonaContacto;
	}

	public InfReferenciaPrincipalCliente getObjInfReferenciaPrincipalCliente() {
		return objInfReferenciaPrincipalCliente;
	}

	public void setObjInfReferenciaPrincipalCliente(InfReferenciaPrincipalCliente objInfReferenciaPrincipalCliente) {
		this.objInfReferenciaPrincipalCliente = objInfReferenciaPrincipalCliente;
	}

	public InfReferenciaPersonaProveedor getObjInfReferenciaPersonaProveedor() {
		return objInfReferenciaPersonaProveedor;
	}

	public void setObjInfReferenciaPersonaProveedor(InfReferenciaPersonaProveedor objInfReferenciaPersonaProveedor) {
		this.objInfReferenciaPersonaProveedor = objInfReferenciaPersonaProveedor;
	}

	public InfTransaccionesExterior getObjInfTransaccionesExterior() {
		return objInfTransaccionesExterior;
	}

	public void setObjInfTransaccionesExterior(InfTransaccionesExterior objInfTransaccionesExterior) {
		this.objInfTransaccionesExterior = objInfTransaccionesExterior;
	}

	public List<RepresentanteLegal> getLstRepresentanteLegal() {
		return lstRepresentanteLegal;
	}

	public void setLstRepresentanteLegal(List<RepresentanteLegal> lstRepresentanteLegal) {
		this.lstRepresentanteLegal = lstRepresentanteLegal;
	}

	public List<Accionista> getLstAccionista() {
		return lstAccionista;
	}

	public void setLstAccionista(List<Accionista> lstAccionista) {
		this.lstAccionista = lstAccionista;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
