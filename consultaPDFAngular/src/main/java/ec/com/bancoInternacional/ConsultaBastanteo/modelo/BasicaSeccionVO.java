package ec.com.bancoInternacional.ConsultaBastanteo.modelo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import ec.com.bancoInternacional.ConsultaBastanteo.util.FormatoUtil;

/**
 * Autor: Nestor Franco Objetivo: Objeto para vista - Seccion B�sica Fecha:
 * 06-07-2018 Nro. Req: 1 Version: 1.0
 */
public class BasicaSeccionVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// Pantalla
	
	private String txtRazonSocial;
	private String txtNombreComercial;
	private String txtObjetoSocial;
	private String txtCapitalSuscrito;
	private String cmbPaisConstitucion;
	private String txtClasificacion;

	private Date dteFechaConstitucion;
	private Date dteFechaVencimiento;
	private String txtDuracion;

	private String cmbCantonResidencia;
	private String cmbProvinciaResidencia;

	// hidden
	
	private String hiddenDteFechaConstitucion;
	private String hiddenDteFechaVencimiento;
	
	// campos ocultos

	private String INBAD1;
	private String INBCAN;
	private String INBCIU;
	private String INBCAR;
	private String INBDIP;
	private String INBDIC;
	private String INBDIM;
	private String INBSTS;
	private String INBPRE;
	private String INBIDN;
	private String INBPMV;
	private String INBPGC;
	private String INBPRM;
	private String INBPES;
	private String INBSLE;
	private String INBTAE;
	private String INBTID;
	private String INBUSC;
	private String INBUSM;
	private String INBVCR;
	
	private BigDecimal INBAD2;
	private BigDecimal INBCUN;
	private BigDecimal INBFEC;
	private BigDecimal INBFAC;
	private BigDecimal INBHOC;
	private BigDecimal INBHOM;
	private BigDecimal INBEXP;
	private BigDecimal INBVNO;

	private BigDecimal INBKAU;
	private BigDecimal INBCSO;
	private BigDecimal INBTIN;
	private BigDecimal INBTAC;
	private BigDecimal INBTPA;

	private Double capitalSuscrito;
	
	public Double getCapitalSuscrito() {
		return capitalSuscrito == null ? new Double(0) : capitalSuscrito;
	}

	public void setCapitalSuscrito(Double capitalSuscrito) {
		this.capitalSuscrito = capitalSuscrito;
	}

	public String getTxtCapitalSuscrito() {
		return txtCapitalSuscrito == null ? new String() : txtCapitalSuscrito;
	}

	public void setTxtCapitalSuscrito(String txtCapitalSuscrito) {
		capitalSuscrito = FormatoUtil.convertirTextoPrimerFormatoNumeroHaciaDecimal(txtCapitalSuscrito);
		this.txtCapitalSuscrito = txtCapitalSuscrito;
	}

	public String getTxtRazonSocial() {
		txtRazonSocial = txtRazonSocial == null ? new String() : txtRazonSocial.toUpperCase();
		return txtRazonSocial;
	}

	public void setTxtRazonSocial(String txtRazonSocial) {
		this.txtRazonSocial = txtRazonSocial;
	}

	public String getTxtNombreComercial() {
		txtNombreComercial = txtNombreComercial == null ? new String() : txtNombreComercial.toUpperCase();
		return txtNombreComercial;
	}

	public void setTxtNombreComercial(String txtNombreComercial) {
		this.txtNombreComercial = txtNombreComercial;
	}

	public String getTxtObjetoSocial() {
		txtObjetoSocial = txtObjetoSocial == null ? new String() : txtObjetoSocial.toUpperCase();
		return txtObjetoSocial;
	}

	public void setTxtObjetoSocial(String txtObjetoSocial) {
		this.txtObjetoSocial = txtObjetoSocial;
	}

	public String getCmbPaisConstitucion() {
		cmbPaisConstitucion = cmbPaisConstitucion == null ? new String() : cmbPaisConstitucion;
		return cmbPaisConstitucion;
	}

	public void setCmbPaisConstitucion(String cmbPaisConstitucion) {
		this.cmbPaisConstitucion = cmbPaisConstitucion;
	}

	public String getCmbCantonResidencia() {
		cmbCantonResidencia = cmbCantonResidencia == null ? new String() : cmbCantonResidencia;
		return cmbCantonResidencia;
	}

	public void setCmbCantonResidencia(String cmbCantonResidencia) {
		this.cmbCantonResidencia = cmbCantonResidencia;
	}

	public String getCmbProvinciaResidencia() {
		cmbProvinciaResidencia = cmbProvinciaResidencia == null ? new String() : cmbProvinciaResidencia;
		return cmbProvinciaResidencia;
	}

	public void setCmbProvinciaResidencia(String cmbProvinciaResidencia) {
		this.cmbProvinciaResidencia = cmbProvinciaResidencia;
	}

	public Date getDteFechaConstitucion() {
		return dteFechaConstitucion;
	}

	public void setDteFechaConstitucion(Date dteFechaConstitucion) {
		this.dteFechaConstitucion = dteFechaConstitucion;
	}

	public Date getDteFechaVencimiento() {
		return dteFechaVencimiento;
	}

	public void setDteFechaVencimiento(Date dteFechaVencimiento) {
		this.dteFechaVencimiento = dteFechaVencimiento;
	}

	public String getTxtDuracion() {
		txtDuracion = txtDuracion == null ? new String() : txtDuracion;
		return txtDuracion;
	}

	public void setTxtDuracion(String txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public String getINBAD1() {
		INBAD1 = INBAD1 == null ? new String() : INBAD1;
		return INBAD1;
	}

	public void setINBAD1(String iNBAD1) {
		INBAD1 = iNBAD1;
	}

	public String getINBCAN() {
		INBCAN = INBCAN == null ? new String() : INBCAN;
		return INBCAN;
	}

	public void setINBCAN(String iNBCAN) {
		INBCAN = iNBCAN;
	}

	public String getINBCIU() {
		INBCIU = INBCIU == null ? new String() : INBCIU;
		return INBCIU;
	}

	public void setINBCIU(String iNBCIU) {
		INBCIU = iNBCIU;
	}

	public String getINBCAR() {
		INBCAR = INBCAR == null ? new String() : INBCAR;
		return INBCAR;
	}

	public void setINBCAR(String iNBCAR) {
		INBCAR = iNBCAR;
	}

	public String getTxtClasificacion() {
		return txtClasificacion;
	}

	public void setTxtClasificacion(String txtClasificacion) {
		this.txtClasificacion = txtClasificacion;
	}

	public String getINBDIP() {
		INBDIP = INBDIP == null ? new String() : INBDIP;
		return INBDIP;
	}

	public void setINBDIP(String iNBDIP) {
		INBDIP = iNBDIP;
	}

	public String getINBDIC() {
		INBDIC = INBDIC == null ? new String() : INBDIC;
		return INBDIC;
	}

	public void setINBDIC(String iNBDIC) {
		INBDIC = iNBDIC;
	}

	public String getINBDIM() {
		INBDIM = INBDIM == null ? new String() : INBDIM;
		return INBDIM;
	}

	public void setINBDIM(String iNBDIM) {
		INBDIM = iNBDIM;
	}

	public String getINBSTS() {
		INBSTS = INBSTS == null ? new String() : INBSTS;
		return INBSTS;
	}

	public void setINBSTS(String iNBSTS) {
		INBSTS = iNBSTS;
	}

	public String getINBPRE() {
		INBPRE = INBPRE == null ? new String() : INBPRE;
		return INBPRE;
	}

	public void setINBPRE(String iNBPRE) {
		INBPRE = iNBPRE;
	}

	public String getINBIDN() {
		INBIDN = INBIDN == null ? new String() : INBIDN;
		return INBIDN;
	}

	public void setINBIDN(String iNBIDN) {
		INBIDN = iNBIDN;
	}

	public String getINBPMV() {
		INBPMV = INBPMV == null ? new String() : INBPMV;
		return INBPMV;
	}

	public void setINBPMV(String iNBPMV) {
		INBPMV = iNBPMV;
	}

	public String getINBPGC() {
		INBPGC = INBPGC == null ? new String() : INBPGC;
		return INBPGC;
	}

	public void setINBPGC(String iNBPGC) {
		INBPGC = iNBPGC;
	}

	public String getINBPRM() {
		INBPRM = INBPRM == null ? new String() : INBPRM;
		return INBPRM;
	}

	public void setINBPRM(String iNBPRM) {
		INBPRM = iNBPRM;
	}

	public String getINBPES() {
		INBPES = INBPES == null ? new String() : INBPES;
		return INBPES;
	}

	public void setINBPES(String iNBPES) {
		INBPES = iNBPES;
	}

	public String getINBSLE() {
		INBSLE = INBSLE == null ? new String() : INBSLE;
		return INBSLE;
	}

	public void setINBSLE(String iNBSLE) {
		INBSLE = iNBSLE;
	}

	public String getINBTAE() {
		INBTAE = INBTAE == null ? new String() : INBTAE;
		return INBTAE;
	}

	public void setINBTAE(String iNBTAE) {
		INBTAE = iNBTAE;
	}

	public String getINBTID() {
		INBTID = INBTID == null ? new String() : INBTID;
		return INBTID;
	}

	public void setINBTID(String iNBTID) {
		INBTID = iNBTID;
	}

	public String getINBUSC() {
		INBUSC = INBUSC == null ? new String() : INBUSC;
		return INBUSC;
	}

	public void setINBUSC(String iNBUSC) {
		INBUSC = iNBUSC;
	}

	public String getINBUSM() {
		INBUSM = INBUSM == null ? new String() : INBUSM;
		return INBUSM;
	}

	public void setINBUSM(String iNBUSM) {
		INBUSM = iNBUSM;
	}

	public String getINBVCR() {
		INBVCR = INBVCR == null ? new String() : INBVCR;
		return INBVCR;
	}

	public void setINBVCR(String iNBVCR) {
		INBVCR = iNBVCR;
	}

	public BigDecimal getINBAD2() {
		INBAD2 = INBAD2 == null ? new BigDecimal(0) : INBAD2;
		return INBAD2;
	}

	public void setINBAD2(BigDecimal iNBAD2) {
		INBAD2 = iNBAD2;
	}

	public BigDecimal getINBCUN() {
		INBCUN = INBCUN == null ? new BigDecimal(0) : INBCUN;
		return INBCUN;
	}

	public void setINBCUN(BigDecimal iNBCUN) {
		INBCUN = iNBCUN;
	}

	public BigDecimal getINBFEC() {
		INBFEC = INBFEC == null ? new BigDecimal(0) : INBFEC;
		return INBFEC;
	}

	public void setINBFEC(BigDecimal iNBFEC) {
		INBFEC = iNBFEC;
	}

	public BigDecimal getINBFAC() {
		INBFAC = INBFAC == null ? new BigDecimal(0) : INBFAC;
		return INBFAC;
	}

	public void setINBFAC(BigDecimal iNBFAC) {
		INBFAC = iNBFAC;
	}

	public BigDecimal getINBHOC() {
		INBHOC = INBHOC == null ? new BigDecimal(0) : INBHOC;
		return INBHOC;
	}

	public void setINBHOC(BigDecimal iNBHOC) {
		INBHOC = iNBHOC;
	}

	public BigDecimal getINBHOM() {
		INBHOM = INBHOM == null ? new BigDecimal(0) : INBHOM;
		return INBHOM;
	}

	public void setINBHOM(BigDecimal iNBHOM) {
		INBHOM = iNBHOM;
	}

	public BigDecimal getINBEXP() {
		INBEXP = INBEXP == null ? new BigDecimal(0) : INBEXP;
		return INBEXP;
	}

	public void setINBEXP(BigDecimal iNBEXP) {
		INBEXP = iNBEXP;
	}

	public BigDecimal getINBVNO() {
		INBVNO = INBVNO == null ? new BigDecimal(0) : INBVNO;
		return INBVNO;
	}

	public void setINBVNO(BigDecimal iNBVNO) {
		INBVNO = iNBVNO;
	}

	public BigDecimal getINBKAU() {
		INBKAU = INBKAU == null ? new BigDecimal(0) : INBKAU;
		return INBKAU;
	}

	public void setINBKAU(BigDecimal iNBKAU) {
		INBKAU = iNBKAU;
	}

	public BigDecimal getINBCSO() {
		INBCSO = INBCSO == null ? new BigDecimal(0) : INBCSO;
		return INBCSO;
	}

	public void setINBCSO(BigDecimal iNBCSO) {
		INBCSO = iNBCSO;
	}

	public BigDecimal getINBTIN() {
		INBTIN = INBTIN == null ? new BigDecimal(0) : INBTIN;
		return INBTIN;
	}

	public void setINBTIN(BigDecimal iNBTIN) {
		INBTIN = iNBTIN;
	}

	public BigDecimal getINBTAC() {
		INBTAC = INBTAC == null ? new BigDecimal(0) : INBTAC;
		return INBTAC;
	}

	public void setINBTAC(BigDecimal iNBTAC) {
		INBTAC = iNBTAC;
	}

	public BigDecimal getINBTPA() {
		INBTPA = INBTPA == null ? new BigDecimal(0) : INBTPA;
		return INBTPA;
	}

	public void setINBTPA(BigDecimal iNBTPA) {
		INBTPA = iNBTPA;
	}

	public String getHiddenDteFechaConstitucion() {
		return hiddenDteFechaConstitucion;
	}

	public void setHiddenDteFechaConstitucion(String hiddenDteFechaConstitucion) {
		this.hiddenDteFechaConstitucion = hiddenDteFechaConstitucion;
	}

	public String getHiddenDteFechaVencimiento() {
		return hiddenDteFechaVencimiento;
	}

	public void setHiddenDteFechaVencimiento(String hiddenDteFechaVencimiento) {
		this.hiddenDteFechaVencimiento = hiddenDteFechaVencimiento;
	}
}
