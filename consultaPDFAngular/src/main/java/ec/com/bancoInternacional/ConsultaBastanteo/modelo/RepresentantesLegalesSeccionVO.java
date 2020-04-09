package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Autor:		Nestor Franco
 * Objetivo:	Objeto para vista - Seccion Representates Legales
 * Fecha:		09-07-2018
 * Nro. Req:	1
 * Version:		1.0
 */
public class RepresentantesLegalesSeccionVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// pantalla
	
	private String cmbTipoIdentificacionRep;
	private String txtIdentificacionRep;
	private String cmbNacionalidadRep;
	private String txtNombreApellidoRep;
	private String cmbCargoRep;
	private Date dteFechaInscripcionRep;
	private Date dteFechaVencimientoRep;
	
	private int maxLenghtIdentificacion;
	
	private String regexIdentification;
	
	// Campos para hiddens
	
	private String hiddenFechaVencimientoRep;
	private String hiddenFechaInscripcionRep ;
	
	// campos ocultos
	
	private String ADMBAR;
	private String ADMCAL;
	private String ADMCSE;
	private String ADMAD1;
	private String ADMCAN;
	private String ADMCAT;
	private String ADMCIN;
	private String ADMMAI;
	private String ADMDIP;
	private String ADMDIC;
	private String ADMDIM;
	private String ADMETC;
	private String ADMIDN;
	private String ADMIDC;
	private String ADMNOC;
	private String ADMCEL;
	private String ADMTPR;
	private String ADMDEP;
	private String ADMNRE;
	private String ADMPIS;
	private String ADMTEL;
	private String ADMPAI;
	private String ADMPAR;
	private String ADMPAA;
	private String ADMPNA;
	private String ADMPGC;
	private String ADMPRM;
	private String ADMPRO;
	private String ADMSAA;
	private String ADMSNA;
	private String ADMTIC;
	private String ADMTID;
	private String ADMTRE;
	private String ADMUSC;
	private String ADMUSM;
	
	private BigDecimal ADMFEC;
	private BigDecimal ADMFEM;
	private BigDecimal ADMFNA;
	private BigDecimal ADMHOC;
	private BigDecimal ADMHOM;
	private BigDecimal ADMAD2;
	
	public String getRegexIdentification() {
		return regexIdentification == null ? new String() : regexIdentification;
	}
	public void setRegexIdentification(String regexIdentification) {
		this.regexIdentification = regexIdentification;
	}
	public int getMaxLenghtIdentificacion() {
		return maxLenghtIdentificacion;
	}
	public void setMaxLenghtIdentificacion(int maxLenghtIdentificacion) {
		this.maxLenghtIdentificacion = maxLenghtIdentificacion;
	}
	public String getHiddenFechaVencimientoRep() {
		return hiddenFechaVencimientoRep;
	}
	public void setHiddenFechaVencimientoRep(String hiddenFechaVencimientoRep) {
		this.hiddenFechaVencimientoRep = hiddenFechaVencimientoRep;
	}
	public String getHiddenFechaInscripcionRep() {
		return hiddenFechaInscripcionRep;
	}
	public void setHiddenFechaInscripcionRep(String hiddenFechaInscripcionRep) {
		this.hiddenFechaInscripcionRep = hiddenFechaInscripcionRep;
	}
	
	public String getCmbTipoIdentificacionRep() {
		cmbTipoIdentificacionRep = cmbTipoIdentificacionRep == null ? new String() : cmbTipoIdentificacionRep.toUpperCase();
		return cmbTipoIdentificacionRep;
	}

	public void setCmbTipoIdentificacionRep(String cmbTipoIdentificacionRep) {
		this.cmbTipoIdentificacionRep = cmbTipoIdentificacionRep;
	}

	public String getTxtIdentificacionRep() {
		txtIdentificacionRep = txtIdentificacionRep == null ? new String() : txtIdentificacionRep.toUpperCase();
		return txtIdentificacionRep;
	}

	public void setTxtIdentificacionRep(String txtIdentificacionRep) {
		this.txtIdentificacionRep = txtIdentificacionRep;
	}

	public String getCmbNacionalidadRep() {
		cmbNacionalidadRep = cmbNacionalidadRep == null ? new String() : cmbNacionalidadRep.toUpperCase();
		return cmbNacionalidadRep;
	}

	public void setCmbNacionalidadRep(String cmbNacionalidadRep) {
		this.cmbNacionalidadRep = cmbNacionalidadRep;
	}

	public String getTxtNombreApellidoRep() {
		txtNombreApellidoRep = txtNombreApellidoRep == null ? new String() : txtNombreApellidoRep.toUpperCase();
		return txtNombreApellidoRep;
	}

	public void setTxtNombreApellidoRep(String txtNombreApellidoRep) {
		this.txtNombreApellidoRep = txtNombreApellidoRep;
	}

	public String getCmbCargoRep() {
		cmbCargoRep = cmbCargoRep == null ? new String() : cmbCargoRep.toUpperCase();
		return cmbCargoRep;
	}

	public void setCmbCargoRep(String cmbCargoRep) {
		this.cmbCargoRep = cmbCargoRep;
	}

	public Date getDteFechaInscripcionRep() {
		return dteFechaInscripcionRep;
	}

	public void setDteFechaInscripcionRep(Date dteFechaInscripcionRep) {
		this.dteFechaInscripcionRep = dteFechaInscripcionRep;
	}

	public Date getDteFechaVencimientoRep() {
		return dteFechaVencimientoRep;
	}

	public void setDteFechaVencimientoRep(Date dteFechaVencimientoRep) {
		this.dteFechaVencimientoRep = dteFechaVencimientoRep;
	}

	public String getADMBAR() {
		ADMBAR = ADMBAR == null ? new String() : ADMBAR;
		return ADMBAR;
	}

	public void setADMBAR(String aDMBAR) {
		ADMBAR = aDMBAR;
	}

	public String getADMCAL() {
		ADMCAL = ADMCAL == null ? new String() : ADMCAL;
		return ADMCAL;
	}

	public void setADMCAL(String aDMCAL) {
		ADMCAL = aDMCAL;
	}

	public String getADMCSE() {
		ADMCSE = ADMCSE == null ? new String() : ADMCSE;
		return ADMCSE;
	}

	public void setADMCSE(String aDMCSE) {
		ADMCSE = aDMCSE;
	}

	public String getADMAD1() {
		ADMAD1 = ADMAD1 == null ? new String() : ADMAD1;
		return ADMAD1;
	}

	public void setADMAD1(String aDMAD1) {
		ADMAD1 = aDMAD1;
	}

	public String getADMCAN() {
		ADMCAN = ADMCAN == null ? new String() : ADMCAN;
		return ADMCAN;
	}

	public void setADMCAN(String aDMCAN) {
		ADMCAN = aDMCAN;
	}

	public String getADMCAT() {
		ADMCAT = ADMCAT == null ? new String() : ADMCAT;
		return ADMCAT;
	}

	public void setADMCAT(String aDMCAT) {
		ADMCAT = aDMCAT;
	}

	public String getADMCIN() {
		ADMCIN = ADMCIN == null ? new String() : ADMCIN;
		return ADMCIN;
	}

	public void setADMCIN(String aDMCIN) {
		ADMCIN = aDMCIN;
	}

	public String getADMMAI() {
		ADMMAI = ADMMAI == null ? new String() : ADMMAI;
		return ADMMAI;
	}

	public void setADMMAI(String aDMMAI) {
		ADMMAI = aDMMAI;
	}

	public String getADMDIP() {
		ADMDIP = ADMDIP == null ? new String() : ADMDIP;
		return ADMDIP;
	}

	public void setADMDIP(String aDMDIP) {
		ADMDIP = aDMDIP;
	}

	public String getADMDIC() {
		ADMDIC = ADMDIC == null ? new String() : ADMDIC;
		return ADMDIC;
	}

	public void setADMDIC(String aDMDIC) {
		ADMDIC = aDMDIC;
	}

	public String getADMDIM() {
		ADMDIM = ADMDIM == null ? new String() : ADMDIM;
		return ADMDIM;
	}

	public void setADMDIM(String aDMDIM) {
		ADMDIM = aDMDIM;
	}

	public String getADMETC() {
		ADMETC = ADMETC == null ? new String() : ADMETC;
		return ADMETC;
	}

	public void setADMETC(String aDMETC) {
		ADMETC = aDMETC;
	}

	public String getADMIDN() {
		ADMIDN = ADMIDN == null ? new String() : ADMIDN;
		return ADMIDN;
	}

	public void setADMIDN(String aDMIDN) {
		ADMIDN = aDMIDN;
	}

	public String getADMIDC() {
		ADMIDC = ADMIDC == null ? new String() : ADMIDC;
		return ADMIDC;
	}

	public void setADMIDC(String aDMIDC) {
		ADMIDC = aDMIDC;
	}

	public String getADMNOC() {
		ADMNOC = ADMNOC == null ? new String() : ADMNOC;
		return ADMNOC;
	}

	public void setADMNOC(String aDMNOC) {
		ADMNOC = aDMNOC;
	}

	public String getADMCEL() {
		ADMCEL = ADMCEL == null ? new String() : ADMCEL;
		return ADMCEL;
	}

	public void setADMCEL(String aDMCEL) {
		ADMCEL = aDMCEL;
	}

	public String getADMTPR() {
		ADMTPR = ADMTPR == null ? new String() : ADMTPR;
		return ADMTPR;
	}

	public void setADMTPR(String aDMTPR) {
		ADMTPR = aDMTPR;
	}

	public String getADMDEP() {
		ADMDEP = ADMDEP == null ? new String() : ADMDEP;
		return ADMDEP;
	}

	public void setADMDEP(String aDMDEP) {
		ADMDEP = aDMDEP;
	}

	public String getADMNRE() {
		ADMNRE = ADMNRE == null ? new String() : ADMNRE;
		return ADMNRE;
	}

	public void setADMNRE(String aDMNRE) {
		ADMNRE = aDMNRE;
	}

	public String getADMPIS() {
		ADMPIS = ADMPIS == null ? new String() : ADMPIS;
		return ADMPIS;
	}

	public void setADMPIS(String aDMPIS) {
		ADMPIS = aDMPIS;
	}

	public String getADMTEL() {
		ADMTEL = ADMTEL == null ? new String() : ADMTEL;
		return ADMTEL;
	}

	public void setADMTEL(String aDMTEL) {
		ADMTEL = aDMTEL;
	}

	public String getADMPAI() {
		ADMPAI = ADMPAI == null ? new String() : ADMPAI;
		return ADMPAI;
	}

	public void setADMPAI(String aDMPAI) {
		ADMPAI = aDMPAI;
	}

	public String getADMPAR() {
		ADMPAR = ADMPAR == null ? new String() : ADMPAR;
		return ADMPAR;
	}

	public void setADMPAR(String aDMPAR) {
		ADMPAR = aDMPAR;
	}

	public String getADMPAA() {
		ADMPAA = ADMPAA == null ? new String() : ADMPAA;
		return ADMPAA;
	}

	public void setADMPAA(String aDMPAA) {
		ADMPAA = aDMPAA;
	}

	public String getADMPNA() {
		ADMPNA = ADMPNA == null ? new String() : ADMPNA;
		return ADMPNA;
	}

	public void setADMPNA(String aDMPNA) {
		ADMPNA = aDMPNA;
	}

	public String getADMPGC() {
		ADMPGC = ADMPGC == null ? new String() : ADMPGC;
		return ADMPGC;
	}

	public void setADMPGC(String aDMPGC) {
		ADMPGC = aDMPGC;
	}

	public String getADMPRM() {
		ADMPRM = ADMPRM == null ? new String() : ADMPRM;
		return ADMPRM;
	}

	public void setADMPRM(String aDMPRM) {
		ADMPRM = aDMPRM;
	}

	public String getADMPRO() {
		ADMPRO = ADMPRO == null ? new String() : ADMPRO;
		return ADMPRO;
	}

	public void setADMPRO(String aDMPRO) {
		ADMPRO = aDMPRO;
	}

	public String getADMSAA() {
		ADMSAA = ADMSAA == null ? new String() : ADMSAA;
		return ADMSAA;
	}

	public void setADMSAA(String aDMSAA) {
		ADMSAA = aDMSAA;
	}

	public String getADMSNA() {
		ADMSNA = ADMSNA == null ? new String() : ADMSNA;
		return ADMSNA;
	}

	public void setADMSNA(String aDMSNA) {
		ADMSNA = aDMSNA;
	}

	public String getADMTIC() {
		ADMTIC = ADMTIC == null ? new String() : ADMTIC;
		return ADMTIC;
	}

	public void setADMTIC(String aDMTIC) {
		ADMTIC = aDMTIC;
	}

	public String getADMTID() {
		ADMTID = ADMTID == null ? new String() : ADMTID;
		return ADMTID;
	}

	public void setADMTID(String aDMTID) {
		ADMTID = aDMTID;
	}

	public String getADMTRE() {
		ADMTRE = ADMTRE == null ? new String() : ADMTRE;
		return ADMTRE;
	}

	public void setADMTRE(String aDMTRE) {
		ADMTRE = aDMTRE;
	}

	public String getADMUSC() {
		ADMUSC = ADMUSC == null ? new String() : ADMUSC;
		return ADMUSC;
	}

	public void setADMUSC(String aDMUSC) {
		ADMUSC = aDMUSC;
	}

	public String getADMUSM() {
		ADMUSM = ADMUSM == null ? new String() : ADMUSM;
		return ADMUSM;
	}

	public void setADMUSM(String aDMUSM) {
		ADMUSM = aDMUSM;
	}

	public BigDecimal getADMFEC() {
		ADMFEC = ADMFEC == null ? new BigDecimal(0) : ADMFEC;
		return ADMFEC;
	}

	public void setADMFEC(BigDecimal aDMFEC) {
		ADMFEC = aDMFEC;
	}

	public BigDecimal getADMFEM() {
		ADMFEM = ADMFEM == null ? new BigDecimal(0) : ADMFEM;
		return ADMFEM;
	}

	public void setADMFEM(BigDecimal aDMFEM) {
		ADMFEM = aDMFEM;
	}

	public BigDecimal getADMFNA() {
		ADMFNA = ADMFNA == null ? new BigDecimal(0) : ADMFNA;
		return ADMFNA;
	}

	public void setADMFNA(BigDecimal aDMFNA) {
		ADMFNA = aDMFNA;
	}

	public BigDecimal getADMHOC() {
		ADMHOC = ADMHOC == null ? new BigDecimal(0) : ADMHOC;
		return ADMHOC;
	}

	public void setADMHOC(BigDecimal aDMHOC) {
		ADMHOC = aDMHOC;
	}

	public BigDecimal getADMHOM() {
		ADMHOM = ADMHOM == null ? new BigDecimal(0) : ADMHOM;
		return ADMHOM;
	}

	public void setADMHOM(BigDecimal aDMHOM) {
		ADMHOM = aDMHOM;
	}

	public BigDecimal getADMAD2() {
		ADMAD2 = ADMAD2 == null ? new BigDecimal(0) : ADMAD2;
		return ADMAD2;
	}

	public void setADMAD2(BigDecimal aDMAD2) {
		ADMAD2 = aDMAD2;
	}
	
}
