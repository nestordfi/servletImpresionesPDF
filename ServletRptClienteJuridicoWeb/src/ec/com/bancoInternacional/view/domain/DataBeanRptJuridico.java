package ec.com.bancoInternacional.view.domain;

import java.io.Serializable;
import java.util.List;

public class DataBeanRptJuridico implements Serializable {
	private static final long serialVersionUID = 4949665694197460798L;
	
//	private String SUBREPORT_DIR;
//	private String IMG_DIR;

	private String cabecera_nombre_banco;
	private String cabecera_nombres_cliente;
	private String cabecera_nombres_representante;
	private String cabecera_cargo_representante;

	private String identificacion_tipo_identificacion;
	private String identificacion_identificacion;
	private String identificacion_razon_social;

	private String infBasica_proposito;
	private String infBasica_razonSocial;
	private String infBasica_nombreComercial;
	private String infBasica_objetoSocial;
	private String infBasica_paisConstitucion;
	private String infBasica_fechaConstitucion;
	private String infBasica_duracion;
	private String infBasica_fechaVencimiento;
	private String infBasica_capitalSuscrito;
	private String infBasica_capitalSocial;
	private String infBasica_fechaInscripcion;
	private String infBasica_nroEmpleados;
	private String infBasica_codigoActEconomica;
	private String infBasica_actEconimicaNx;
	private String infBasica_clasificacion;

	private String infFinanciera_ingresosAnuales;
	private String infFinanciera_totalActivos;
	private String infFinanciera_totalPasivos;
	private String infFinanciera_patrimonio;

	private String fatca_representacionSi;
	private String fatca_representacionNo;
	private String fatca_porcentaje;
	private String fatcaparticipacionSi;
	private String fatcaparticipacionNo;

	private String infContacto_ubicacion_pais;
	private String infContacto_ubicacion_canton;
	private String infContacto_ubicacion_provincia;
	private String infContacto_ubicacion_parroquia;
	private String infContacto_ubicacion_calle;
	private String infContacto_ubicacion_nro;
	private String infContacto_ubicacion_calleSecundaria;
	private String infContacto_ubicacion_piso;
	private String infContacto_ubicacion_departamento;
	private String infContacto_ubicacion_barrio;
	private String infContacto_ubicacion_referencia;

	private String infContacto_tlfContacto_tlf1;
	private String infContacto_tlfContacto_tlf2;
	private String infContacto_tlfContacto_cell1;
	private String infContacto_tlfContacto_cell2;
	private String infContacto_tlfContacto_notificacionCell1;
	private String infContacto_tlfContacto_notificaionnCell2;

	private String infContacto_correo_correo1;
	private String infContacto_correo_correo2;
	private String infContacto_correo_notificaionCorreo1;
	private String infContacto_correo_notificaionCorreo2;

	private String infReferencia_contacto_nombre;
	private String infReferencia_contacto_cargo;
	private String infReferencia_contacto_telefono;
	private String infReferencia_contacto_celular;
	private String infReferencia_contacto_correo;

	private String infReferencia_clientes_nombre;
	private String infReferencia_clientes_canton;
	private String infReferencia_clientes_telefono;
	private String infReferencia_clientes_celular;

	private String infReferencia_proveedor_nombre;
	private String infReferencia_proveedor_canton;
	private String infReferencia_proveedor_telefono;
	private String infReferencia_proveedor_celular;

	private String infTranExterior_montoDepositoMensual;
	private String infTranExterior_montoRetiroMensual;
	private String infTranExterior_recibiraSi;
	private String infTranExterior_recibiraNo;
	private String infTranExterior_montoAnualRecibira;
	private String infTranExterior_paisOrigen;
	private String infTranExterior_enviaraSi;
	private String infTranExterior_enviaraNo;
	private String infTranExterior_montoAnualEnviara;
	private String infTranExterior_paisDestino;

	private String infAdicional_otroInstitucionSi;
	private String infAdicional_otroInstitucionNo;
	private String infAdicional_institucion;
	private String infAdicional_observaciones;
	
	private List<RepLegalesDto> repLegalesList;
	private List<BeneficiarioDto> beneficiariosList;
	private List<AccionistasDto> accionistasList;
	private List<RepLegalesDto> repLegalesListExcluyendoElPrimero;
	
	public DataBeanRptJuridico() {
		super();
	}

	public String getCabecera_nombre_banco() {
		return cabecera_nombre_banco;
	}

	public void setCabecera_nombre_banco(String cabecera_nombre_banco) {
		this.cabecera_nombre_banco = cabecera_nombre_banco;
	}

	public String getCabecera_nombres_cliente() {
		return cabecera_nombres_cliente;
	}

	public void setCabecera_nombres_cliente(String cabecera_nombres_cliente) {
		this.cabecera_nombres_cliente = cabecera_nombres_cliente;
	}

	public String getCabecera_nombres_representante() {
		return cabecera_nombres_representante;
	}

	public void setCabecera_nombres_representante(String cabecera_nombres_representante) {
		this.cabecera_nombres_representante = cabecera_nombres_representante;
	}

	public String getCabecera_cargo_representante() {
		return cabecera_cargo_representante;
	}

	public void setCabecera_cargo_representante(String cabecera_cargo_representante) {
		this.cabecera_cargo_representante = cabecera_cargo_representante;
	}

	public String getIdentificacion_tipo_identificacion() {
		return identificacion_tipo_identificacion;
	}

	public void setIdentificacion_tipo_identificacion(String identificacion_tipo_identificacion) {
		this.identificacion_tipo_identificacion = identificacion_tipo_identificacion;
	}

	public String getIdentificacion_identificacion() {
		return identificacion_identificacion;
	}

	public void setIdentificacion_identificacion(String identificacion_identificacion) {
		this.identificacion_identificacion = identificacion_identificacion;
	}

	public String getIdentificacion_razon_social() {
		return identificacion_razon_social;
	}

	public void setIdentificacion_razon_social(String identificacion_razon_social) {
		this.identificacion_razon_social = identificacion_razon_social;
	}

	public String getInfBasica_proposito() {
		return infBasica_proposito;
	}

	public void setInfBasica_proposito(String infBasica_proposito) {
		this.infBasica_proposito = infBasica_proposito;
	}

	public String getInfBasica_razonSocial() {
		return infBasica_razonSocial;
	}

	public void setInfBasica_razonSocial(String infBasica_razonSocial) {
		this.infBasica_razonSocial = infBasica_razonSocial;
	}

	public String getInfBasica_nombreComercial() {
		return infBasica_nombreComercial;
	}

	public void setInfBasica_nombreComercial(String infBasica_nombreComercial) {
		this.infBasica_nombreComercial = infBasica_nombreComercial;
	}

	public String getInfBasica_objetoSocial() {
		return infBasica_objetoSocial;
	}

	public void setInfBasica_objetoSocial(String infBasica_objetoSocial) {
		this.infBasica_objetoSocial = infBasica_objetoSocial;
	}

	public String getInfBasica_paisConstitucion() {
		return infBasica_paisConstitucion;
	}

	public void setInfBasica_paisConstitucion(String infBasica_paisConstitucion) {
		this.infBasica_paisConstitucion = infBasica_paisConstitucion;
	}

	public String getInfBasica_fechaConstitucion() {
		return infBasica_fechaConstitucion;
	}

	public void setInfBasica_fechaConstitucion(String infBasica_fechaConstitucion) {
		this.infBasica_fechaConstitucion = infBasica_fechaConstitucion;
	}

	public String getInfBasica_duracion() {
		return infBasica_duracion;
	}

	public void setInfBasica_duracion(String infBasica_duracion) {
		this.infBasica_duracion = infBasica_duracion;
	}

	public String getInfBasica_fechaVencimiento() {
		return infBasica_fechaVencimiento;
	}

	public void setInfBasica_fechaVencimiento(String infBasica_fechaVencimiento) {
		this.infBasica_fechaVencimiento = infBasica_fechaVencimiento;
	}

	public String getInfBasica_capitalSuscrito() {
		return infBasica_capitalSuscrito;
	}

	public void setInfBasica_capitalSuscrito(String infBasica_capitalSuscrito) {
		this.infBasica_capitalSuscrito = infBasica_capitalSuscrito;
	}

	public String getInfBasica_capitalSocial() {
		return infBasica_capitalSocial;
	}

	public void setInfBasica_capitalSocial(String infBasica_capitalSocial) {
		this.infBasica_capitalSocial = infBasica_capitalSocial;
	}

	public String getInfBasica_fechaInscripcion() {
		return infBasica_fechaInscripcion;
	}

	public void setInfBasica_fechaInscripcion(String infBasica_fechaInscripcion) {
		this.infBasica_fechaInscripcion = infBasica_fechaInscripcion;
	}

	public String getInfBasica_codigoActEconomica() {
		return infBasica_codigoActEconomica;
	}

	public void setInfBasica_codigoActEconomica(String infBasica_codigoActEconomica) {
		this.infBasica_codigoActEconomica = infBasica_codigoActEconomica;
	}

	public String getInfBasica_actEconimicaNx() {
		return infBasica_actEconimicaNx;
	}

	public void setInfBasica_actEconimicaNx(String infBasica_actEconimicaNx) {
		this.infBasica_actEconimicaNx = infBasica_actEconimicaNx;
	}

	public String getInfBasica_clasificacion() {
		return infBasica_clasificacion;
	}

	public void setInfBasica_clasificacion(String infBasica_clasificacion) {
		this.infBasica_clasificacion = infBasica_clasificacion;
	}

	public String getInfFinanciera_ingresosAnuales() {
		return infFinanciera_ingresosAnuales;
	}

	public void setInfFinanciera_ingresosAnuales(String infFinanciera_ingresosAnuales) {
		this.infFinanciera_ingresosAnuales = infFinanciera_ingresosAnuales;
	}

	public String getInfFinanciera_totalActivos() {
		return infFinanciera_totalActivos;
	}

	public void setInfFinanciera_totalActivos(String infFinanciera_totalActivos) {
		this.infFinanciera_totalActivos = infFinanciera_totalActivos;
	}

	public String getInfFinanciera_totalPasivos() {
		return infFinanciera_totalPasivos;
	}

	public void setInfFinanciera_totalPasivos(String infFinanciera_totalPasivos) {
		this.infFinanciera_totalPasivos = infFinanciera_totalPasivos;
	}

	public String getInfFinanciera_patrimonio() {
		return infFinanciera_patrimonio;
	}

	public void setInfFinanciera_patrimonio(String infFinanciera_patrimonio) {
		this.infFinanciera_patrimonio = infFinanciera_patrimonio;
	}

	public String getFatca_representacionSi() {
		return fatca_representacionSi;
	}

	public void setFatca_representacionSi(String fatca_representacionSi) {
		this.fatca_representacionSi = fatca_representacionSi;
	}

	public String getFatca_representacionNo() {
		return fatca_representacionNo;
	}

	public void setFatca_representacionNo(String fatca_representacionNo) {
		this.fatca_representacionNo = fatca_representacionNo;
	}

	public String getFatca_porcentaje() {
		return fatca_porcentaje;
	}

	public void setFatca_porcentaje(String fatca_porcentaje) {
		this.fatca_porcentaje = fatca_porcentaje;
	}

	public String getFatcaparticipacionSi() {
		return fatcaparticipacionSi;
	}

	public void setFatcaparticipacionSi(String fatcaparticipacionSi) {
		this.fatcaparticipacionSi = fatcaparticipacionSi;
	}

	public String getFatcaparticipacionNo() {
		return fatcaparticipacionNo;
	}

	public void setFatcaparticipacionNo(String fatcaparticipacionNo) {
		this.fatcaparticipacionNo = fatcaparticipacionNo;
	}

	public String getInfContacto_ubicacion_pais() {
		return infContacto_ubicacion_pais;
	}

	public void setInfContacto_ubicacion_pais(String infContacto_ubicacion_pais) {
		this.infContacto_ubicacion_pais = infContacto_ubicacion_pais;
	}

	public String getInfContacto_ubicacion_canton() {
		return infContacto_ubicacion_canton;
	}

	public void setInfContacto_ubicacion_canton(String infContacto_ubicacion_canton) {
		this.infContacto_ubicacion_canton = infContacto_ubicacion_canton;
	}

	public String getInfContacto_ubicacion_provincia() {
		return infContacto_ubicacion_provincia;
	}

	public void setInfContacto_ubicacion_provincia(String infContacto_ubicacion_provincia) {
		this.infContacto_ubicacion_provincia = infContacto_ubicacion_provincia;
	}

	public String getInfContacto_ubicacion_parroquia() {
		return infContacto_ubicacion_parroquia;
	}

	public void setInfContacto_ubicacion_parroquia(String infContacto_ubicacion_parroquia) {
		this.infContacto_ubicacion_parroquia = infContacto_ubicacion_parroquia;
	}

	public String getInfContacto_ubicacion_calle() {
		return infContacto_ubicacion_calle;
	}

	public void setInfContacto_ubicacion_calle(String infContacto_ubicacion_calle) {
		this.infContacto_ubicacion_calle = infContacto_ubicacion_calle;
	}

	public String getInfContacto_ubicacion_nro() {
		return infContacto_ubicacion_nro;
	}

	public void setInfContacto_ubicacion_nro(String infContacto_ubicacion_nro) {
		this.infContacto_ubicacion_nro = infContacto_ubicacion_nro;
	}

	public String getInfContacto_ubicacion_calleSecundaria() {
		return infContacto_ubicacion_calleSecundaria;
	}

	public void setInfContacto_ubicacion_calleSecundaria(String infContacto_ubicacion_calleSecundaria) {
		this.infContacto_ubicacion_calleSecundaria = infContacto_ubicacion_calleSecundaria;
	}

	public String getInfContacto_ubicacion_piso() {
		return infContacto_ubicacion_piso;
	}

	public void setInfContacto_ubicacion_piso(String infContacto_ubicacion_piso) {
		this.infContacto_ubicacion_piso = infContacto_ubicacion_piso;
	}

	public String getInfContacto_ubicacion_departamento() {
		return infContacto_ubicacion_departamento;
	}

	public void setInfContacto_ubicacion_departamento(String infContacto_ubicacion_departamento) {
		this.infContacto_ubicacion_departamento = infContacto_ubicacion_departamento;
	}

	public String getInfContacto_ubicacion_barrio() {
		return infContacto_ubicacion_barrio;
	}

	public void setInfContacto_ubicacion_barrio(String infContacto_ubicacion_barrio) {
		this.infContacto_ubicacion_barrio = infContacto_ubicacion_barrio;
	}

	public String getInfContacto_ubicacion_referencia() {
		return infContacto_ubicacion_referencia;
	}

	public void setInfContacto_ubicacion_referencia(String infContacto_ubicacion_referencia) {
		this.infContacto_ubicacion_referencia = infContacto_ubicacion_referencia;
	}

	public String getInfContacto_tlfContacto_tlf1() {
		return infContacto_tlfContacto_tlf1;
	}

	public void setInfContacto_tlfContacto_tlf1(String infContacto_tlfContacto_tlf1) {
		this.infContacto_tlfContacto_tlf1 = infContacto_tlfContacto_tlf1;
	}

	public String getInfContacto_tlfContacto_tlf2() {
		return infContacto_tlfContacto_tlf2;
	}

	public void setInfContacto_tlfContacto_tlf2(String infContacto_tlfContacto_tlf2) {
		this.infContacto_tlfContacto_tlf2 = infContacto_tlfContacto_tlf2;
	}

	public String getInfContacto_tlfContacto_cell1() {
		return infContacto_tlfContacto_cell1;
	}

	public void setInfContacto_tlfContacto_cell1(String infContacto_tlfContacto_cell1) {
		this.infContacto_tlfContacto_cell1 = infContacto_tlfContacto_cell1;
	}

	public String getInfContacto_tlfContacto_cell2() {
		return infContacto_tlfContacto_cell2;
	}

	public void setInfContacto_tlfContacto_cell2(String infContacto_tlfContacto_cell2) {
		this.infContacto_tlfContacto_cell2 = infContacto_tlfContacto_cell2;
	}

	public String getInfContacto_tlfContacto_notificacionCell1() {
		return infContacto_tlfContacto_notificacionCell1;
	}

	public void setInfContacto_tlfContacto_notificacionCell1(String infContacto_tlfContacto_notificacionCell1) {
		this.infContacto_tlfContacto_notificacionCell1 = infContacto_tlfContacto_notificacionCell1;
	}

	public String getInfContacto_tlfContacto_notificaionnCell2() {
		return infContacto_tlfContacto_notificaionnCell2;
	}

	public void setInfContacto_tlfContacto_notificaionnCell2(String infContacto_tlfContacto_notificaionnCell2) {
		this.infContacto_tlfContacto_notificaionnCell2 = infContacto_tlfContacto_notificaionnCell2;
	}

	public String getInfContacto_correo_correo1() {
		return infContacto_correo_correo1;
	}

	public void setInfContacto_correo_correo1(String infContacto_correo_correo1) {
		this.infContacto_correo_correo1 = infContacto_correo_correo1;
	}

	public String getInfContacto_correo_correo2() {
		return infContacto_correo_correo2;
	}

	public void setInfContacto_correo_correo2(String infContacto_correo_correo2) {
		this.infContacto_correo_correo2 = infContacto_correo_correo2;
	}

	public String getInfContacto_correo_notificaionCorreo1() {
		return infContacto_correo_notificaionCorreo1;
	}

	public void setInfContacto_correo_notificaionCorreo1(String infContacto_correo_notificaionCorreo1) {
		this.infContacto_correo_notificaionCorreo1 = infContacto_correo_notificaionCorreo1;
	}

	public String getInfContacto_correo_notificaionCorreo2() {
		return infContacto_correo_notificaionCorreo2;
	}

	public void setInfContacto_correo_notificaionCorreo2(String infContacto_correo_notificaionCorreo2) {
		this.infContacto_correo_notificaionCorreo2 = infContacto_correo_notificaionCorreo2;
	}

	public String getInfReferencia_contacto_nombre() {
		return infReferencia_contacto_nombre;
	}

	public void setInfReferencia_contacto_nombre(String infReferencia_contacto_nombre) {
		this.infReferencia_contacto_nombre = infReferencia_contacto_nombre;
	}

	public String getInfReferencia_contacto_cargo() {
		return infReferencia_contacto_cargo;
	}

	public void setInfReferencia_contacto_cargo(String infReferencia_contacto_cargo) {
		this.infReferencia_contacto_cargo = infReferencia_contacto_cargo;
	}

	public String getInfReferencia_contacto_telefono() {
		return infReferencia_contacto_telefono;
	}

	public void setInfReferencia_contacto_telefono(String infReferencia_contacto_telefono) {
		this.infReferencia_contacto_telefono = infReferencia_contacto_telefono;
	}

	public String getInfReferencia_contacto_celular() {
		return infReferencia_contacto_celular;
	}

	public void setInfReferencia_contacto_celular(String infReferencia_contacto_celular) {
		this.infReferencia_contacto_celular = infReferencia_contacto_celular;
	}

	public String getInfReferencia_contacto_correo() {
		return infReferencia_contacto_correo;
	}

	public void setInfReferencia_contacto_correo(String infReferencia_contacto_correo) {
		this.infReferencia_contacto_correo = infReferencia_contacto_correo;
	}

	public String getInfReferencia_clientes_nombre() {
		return infReferencia_clientes_nombre;
	}

	public void setInfReferencia_clientes_nombre(String infReferencia_clientes_nombre) {
		this.infReferencia_clientes_nombre = infReferencia_clientes_nombre;
	}

	public String getInfReferencia_clientes_telefono() {
		return infReferencia_clientes_telefono;
	}

	public void setInfReferencia_clientes_telefono(String infReferencia_clientes_telefono) {
		this.infReferencia_clientes_telefono = infReferencia_clientes_telefono;
	}

	public String getInfReferencia_clientes_celular() {
		return infReferencia_clientes_celular;
	}

	public void setInfReferencia_clientes_celular(String infReferencia_clientes_celular) {
		this.infReferencia_clientes_celular = infReferencia_clientes_celular;
	}

	public String getInfReferencia_proveedor_nombre() {
		return infReferencia_proveedor_nombre;
	}

	public void setInfReferencia_proveedor_nombre(String infReferencia_proveedor_nombre) {
		this.infReferencia_proveedor_nombre = infReferencia_proveedor_nombre;
	}


	public String getInfReferencia_proveedor_telefono() {
		return infReferencia_proveedor_telefono;
	}

	public void setInfReferencia_proveedor_telefono(String infReferencia_proveedor_telefono) {
		this.infReferencia_proveedor_telefono = infReferencia_proveedor_telefono;
	}

	public String getInfReferencia_proveedor_celular() {
		return infReferencia_proveedor_celular;
	}

	public void setInfReferencia_proveedor_celular(String infReferencia_proveedor_celular) {
		this.infReferencia_proveedor_celular = infReferencia_proveedor_celular;
	}

	public String getInfTranExterior_montoDepositoMensual() {
		return infTranExterior_montoDepositoMensual;
	}

	public void setInfTranExterior_montoDepositoMensual(String infTranExterior_montoDepositoMensual) {
		this.infTranExterior_montoDepositoMensual = infTranExterior_montoDepositoMensual;
	}

	public String getInfTranExterior_montoRetiroMensual() {
		return infTranExterior_montoRetiroMensual;
	}

	public void setInfTranExterior_montoRetiroMensual(String infTranExterior_montoRetiroMensual) {
		this.infTranExterior_montoRetiroMensual = infTranExterior_montoRetiroMensual;
	}

	public String getInfTranExterior_recibiraSi() {
		return infTranExterior_recibiraSi;
	}

	public void setInfTranExterior_recibiraSi(String infTranExterior_recibiraSi) {
		this.infTranExterior_recibiraSi = infTranExterior_recibiraSi;
	}

	public String getInfTranExterior_recibiraNo() {
		return infTranExterior_recibiraNo;
	}

	public void setInfTranExterior_recibiraNo(String infTranExterior_recibiraNo) {
		this.infTranExterior_recibiraNo = infTranExterior_recibiraNo;
	}

	public String getInfTranExterior_montoAnualRecibira() {
		return infTranExterior_montoAnualRecibira;
	}

	public void setInfTranExterior_montoAnualRecibira(String infTranExterior_montoAnualRecibira) {
		this.infTranExterior_montoAnualRecibira = infTranExterior_montoAnualRecibira;
	}

	public String getInfTranExterior_paisOrigen() {
		return infTranExterior_paisOrigen;
	}

	public void setInfTranExterior_paisOrigen(String infTranExterior_paisOrigen) {
		this.infTranExterior_paisOrigen = infTranExterior_paisOrigen;
	}

	public String getInfTranExterior_enviaraSi() {
		return infTranExterior_enviaraSi;
	}

	public void setInfTranExterior_enviaraSi(String infTranExterior_enviaraSi) {
		this.infTranExterior_enviaraSi = infTranExterior_enviaraSi;
	}

	public String getInfTranExterior_enviaraNo() {
		return infTranExterior_enviaraNo;
	}

	public void setInfTranExterior_enviaraNo(String infTranExterior_enviaraNo) {
		this.infTranExterior_enviaraNo = infTranExterior_enviaraNo;
	}

	public String getInfTranExterior_montoAnualEnviara() {
		return infTranExterior_montoAnualEnviara;
	}

	public void setInfTranExterior_montoAnualEnviara(String infTranExterior_montoAnualEnviara) {
		this.infTranExterior_montoAnualEnviara = infTranExterior_montoAnualEnviara;
	}

	public String getInfTranExterior_paisDestino() {
		return infTranExterior_paisDestino;
	}

	public void setInfTranExterior_paisDestino(String infTranExterior_paisDestino) {
		this.infTranExterior_paisDestino = infTranExterior_paisDestino;
	}

	public String getInfAdicional_otroInstitucionSi() {
		return infAdicional_otroInstitucionSi;
	}

	public void setInfAdicional_otroInstitucionSi(String infAdicional_otroInstitucionSi) {
		this.infAdicional_otroInstitucionSi = infAdicional_otroInstitucionSi;
	}

	public String getInfAdicional_otroInstitucionNo() {
		return infAdicional_otroInstitucionNo;
	}

	public void setInfAdicional_otroInstitucionNo(String infAdicional_otroInstitucionNo) {
		this.infAdicional_otroInstitucionNo = infAdicional_otroInstitucionNo;
	}

	public String getInfAdicional_institucion() {
		return infAdicional_institucion;
	}

	public void setInfAdicional_institucion(String infAdicional_institucion) {
		this.infAdicional_institucion = infAdicional_institucion;
	}

	public String getInfAdicional_observaciones() {
		return infAdicional_observaciones;
	}

	public void setInfAdicional_observaciones(String infAdicional_observaciones) {
		this.infAdicional_observaciones = infAdicional_observaciones;
	}

	public List<RepLegalesDto> getRepLegalesList() {
		return repLegalesList;
	}

	public void setRepLegalesList(List<RepLegalesDto> repLegalesList) {
		this.repLegalesList = repLegalesList;
	}

	public List<BeneficiarioDto> getBeneficiariosList() {
		return beneficiariosList;
	}

	public void setBeneficiariosList(List<BeneficiarioDto> beneficiariosList) {
		this.beneficiariosList = beneficiariosList;
	}

	public List<AccionistasDto> getAccionistasList() {
		return accionistasList;
	}

	public void setAccionistasList(List<AccionistasDto> accionistasList) {
		this.accionistasList = accionistasList;
	}

	public String getInfBasica_nroEmpleados() {
		return infBasica_nroEmpleados;
	}

	public void setInfBasica_nroEmpleados(String infBasica_nroEmpleados) {
		this.infBasica_nroEmpleados = infBasica_nroEmpleados;
	}

	public String getInfReferencia_clientes_canton() {
		return infReferencia_clientes_canton;
	}

	public void setInfReferencia_clientes_canton(String infReferencia_clientes_canton) {
		this.infReferencia_clientes_canton = infReferencia_clientes_canton;
	}

	public String getInfReferencia_proveedor_canton() {
		return infReferencia_proveedor_canton;
	}

	public void setInfReferencia_proveedor_canton(String infReferencia_proveedor_canton) {
		this.infReferencia_proveedor_canton = infReferencia_proveedor_canton;
	}

	public List<RepLegalesDto> getRepLegalesListExcluyendoElPrimero() {
		return repLegalesListExcluyendoElPrimero;
	}

	public void setRepLegalesListExcluyendoElPrimero(List<RepLegalesDto> repLegalesListExcluyendoElPrimero) {
		this.repLegalesListExcluyendoElPrimero = repLegalesListExcluyendoElPrimero;
	}
}
