package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import ec.com.bancoInternacional.ConsultaBastanteo.util.FormatoUtil;

/**
 * Autor: Nestor Franco Objetivo: Objeto para vista - Seccion Accionistas Fecha:
 * 16-07-2018 Nro. Req: 1 Version: 1.0
 */
public class AccionistasSeccionVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String radNaturalJuridicoAccionistas;
	private String txtIdentificacionAccionistas;
	private String txtRazonSocialAccionistas;
	private String txtPrimerNombreAccionistas;
	private String txtSegundoNombreAccionistas;
	private String txtPrimerApellidoAccionistas;
	private String txtSegundoApellidoAccionistas;
	private String txtPorcentajeAccionistas;
	private String txtMontoAccionistas;
	private String cmbNacionalidadAccionistas;
	private String cmbTipoIdentificacion;
	private String regexIdentification;
	
	private int maxLenghtIdentificacion;
	
	// campos ocultos

	private String ACCBPA;
	private String ACCBPN;
	private String ACCBSA;
	private String ACCBSN;
	private String ACCBNA;
	private String ACCBTI;
	private String ACCAD1;
	private String ACCCAN;
	private String ACCDIP;
	private String ACCIDN;
	private String ACCCIU;
	private String ACCEST;
	private String ACCDIR;
	private String ACCDIC;
	private String ACCDIM;
	private String ACCIDA;
	private String ACCBID;
	private String ACCPEP;
	private String ACCPGC;
	private String ACCPGM;
	private String ACCTIP;
	private String ACCUSC;
	private String ACCUSM;

	private BigDecimal ACCFEC;
	private BigDecimal ACCFEM;
	private BigDecimal ACCHOC;
	private BigDecimal ACCHOM;

	private BigDecimal ACCAD2;
	private BigDecimal ACCCAP;

	private Double porcentajeAcciones;
	private Double montoAcciones;
	
	private Integer identificadorDePosicion;
	
	public Integer getIdentificadorDePosicion() {
		return identificadorDePosicion == null ? new Integer(0) : identificadorDePosicion;
	}

	public void setIdentificadorDePosicion(Integer identificadorDePosicion) {
		this.identificadorDePosicion = identificadorDePosicion;
	}

	public Double getPorcentajeAcciones() {
		return porcentajeAcciones == null ? new Double(0) : porcentajeAcciones;
	}

	public void setPorcentajeAcciones(Double porcentajeAcciones) {
		this.porcentajeAcciones = porcentajeAcciones;
	}

	public Double getMontoAcciones() {
		return montoAcciones == null ? new Double(0) : montoAcciones;
	}

	public void setMontoAcciones(Double montoAcciones) {
		this.montoAcciones = montoAcciones;
	}

	public String getRegexIdentification() {
		return regexIdentification;
	}

	public void setRegexIdentification(String regexIdentification) {
		this.regexIdentification = regexIdentification;
	}

	public String getTxtRazonSocialAccionistas() {
		txtRazonSocialAccionistas = txtRazonSocialAccionistas == null ? new String() : txtRazonSocialAccionistas.toUpperCase();
		return txtRazonSocialAccionistas;
	}

	public void setTxtRazonSocialAccionistas(String txtRazonSocialAccionistas) {
		this.txtRazonSocialAccionistas = txtRazonSocialAccionistas;
	}

	public String getTxtPrimerNombreAccionistas() {
		txtPrimerNombreAccionistas = txtPrimerNombreAccionistas == null ? new String() : txtPrimerNombreAccionistas.toUpperCase();
		return txtPrimerNombreAccionistas;
	}

	public void setTxtPrimerNombreAccionistas(String txtPrimerNombreAccionistas) {
		this.txtPrimerNombreAccionistas = txtPrimerNombreAccionistas;
	}

	public String getTxtSegundoNombreAccionistas() {
		txtSegundoNombreAccionistas = txtSegundoNombreAccionistas == null ? new String() : txtSegundoNombreAccionistas.toUpperCase();
		return txtSegundoNombreAccionistas;
	}

	public void setTxtSegundoNombreAccionistas(String txtSegundoNombreAccionistas) {
		this.txtSegundoNombreAccionistas = txtSegundoNombreAccionistas;
	}

	public String getTxtPrimerApellidoAccionistas() {
		txtPrimerApellidoAccionistas = txtPrimerApellidoAccionistas == null ? new String()
				: txtPrimerApellidoAccionistas.toUpperCase();
		return txtPrimerApellidoAccionistas;
	}

	public void setTxtPrimerApellidoAccionistas(String txtPrimerApellidoAccionistas) {
		this.txtPrimerApellidoAccionistas = txtPrimerApellidoAccionistas;
	}

	public String getTxtSegundoApellidoAccionistas() {
		txtSegundoApellidoAccionistas = txtSegundoApellidoAccionistas == null ? new String()
				: txtSegundoApellidoAccionistas.toUpperCase();
		return txtSegundoApellidoAccionistas;
	}

	public void setTxtSegundoApellidoAccionistas(String txtSegundoApellidoAccionistas) {
		this.txtSegundoApellidoAccionistas = txtSegundoApellidoAccionistas;
	}

	public String getCmbTipoIdentificacion() {
		cmbTipoIdentificacion = cmbTipoIdentificacion == null ? new String() : cmbTipoIdentificacion;
		return cmbTipoIdentificacion;
	}

	public void setCmbTipoIdentificacion(String cmbTipoIdentificacion) {
		this.cmbTipoIdentificacion = cmbTipoIdentificacion;
	}

	public String getRadNaturalJuridicoAccionistas() {
		radNaturalJuridicoAccionistas = radNaturalJuridicoAccionistas == null ? new String()
				: radNaturalJuridicoAccionistas;
		return radNaturalJuridicoAccionistas;
	}

	public void setRadNaturalJuridicoAccionistas(String radNaturalJuridicoAccionistas) {
		this.radNaturalJuridicoAccionistas = radNaturalJuridicoAccionistas;
	}

	public String getTxtIdentificacionAccionistas() {
		txtIdentificacionAccionistas = txtIdentificacionAccionistas == null ? new String()
				: txtIdentificacionAccionistas;
		return txtIdentificacionAccionistas.toUpperCase();
	}

	public void setTxtIdentificacionAccionistas(String txtIdentificacionAccionistas) {
		this.txtIdentificacionAccionistas = txtIdentificacionAccionistas;
	}

	public String getTxtPorcentajeAccionistas() {
		txtPorcentajeAccionistas = txtPorcentajeAccionistas == null ? new String() : txtPorcentajeAccionistas;
		return txtPorcentajeAccionistas;
	}

	public void setTxtPorcentajeAccionistas(String txtPorcentajeAccionistas) {
		porcentajeAcciones = FormatoUtil.convertirTextoPrimerFormatoNumeroHaciaDecimal(txtPorcentajeAccionistas);
		this.txtPorcentajeAccionistas = txtPorcentajeAccionistas;
	}

	public String getTxtMontoAccionistas() {
		return txtMontoAccionistas == null ? new String() : txtMontoAccionistas;
	}

	public void setTxtMontoAccionistas(String txtMontoAccionistas) {
		montoAcciones = FormatoUtil.convertirTextoPrimerFormatoNumeroHaciaDecimal(txtMontoAccionistas);
		this.txtMontoAccionistas = txtMontoAccionistas;
	}

	public String getCmbNacionalidadAccionistas() {
		cmbNacionalidadAccionistas = cmbNacionalidadAccionistas == null ? new String() : cmbNacionalidadAccionistas;
		return cmbNacionalidadAccionistas;
	}

	public void setCmbNacionalidadAccionistas(String cmbNacionalidadAccionistas) {
		this.cmbNacionalidadAccionistas = cmbNacionalidadAccionistas;
	}

	public String getACCBPA() {
		ACCBPA = ACCBPA == null ? new String() : ACCBPA;
		return ACCBPA;
	}

	public void setACCBPA(String aCCBPA) {
		ACCBPA = aCCBPA;
	}

	public String getACCBPN() {
		ACCBPN = ACCBPN == null ? new String() : ACCBPN;
		return ACCBPN;
	}

	public void setACCBPN(String aCCBPN) {
		ACCBPN = aCCBPN;
	}

	public String getACCBSA() {
		ACCBSA = ACCBSA == null ? new String() : ACCBSA;
		return ACCBSA;
	}

	public void setACCBSA(String aCCBSA) {
		ACCBSA = aCCBSA;
	}

	public String getACCBSN() {
		ACCBSN = ACCBSN == null ? new String() : ACCBSN;
		return ACCBSN;
	}

	public void setACCBSN(String aCCBSN) {
		ACCBSN = aCCBSN;
	}

	public String getACCBNA() {
		ACCBNA = ACCBNA == null ? new String() : ACCBNA;
		return ACCBNA;
	}

	public void setACCBNA(String aCCBNA) {
		ACCBNA = aCCBNA;
	}

	public String getACCBTI() {
		ACCBTI = ACCBTI == null ? new String() : ACCBTI;
		return ACCBTI;
	}

	public void setACCBTI(String aCCBTI) {
		ACCBTI = aCCBTI;
	}

	public String getACCAD1() {
		ACCAD1 = ACCAD1 == null ? new String() : ACCAD1;
		return ACCAD1;
	}

	public void setACCAD1(String aCCAD1) {
		ACCAD1 = aCCAD1;
	}

	public String getACCCAN() {
		ACCCAN = ACCCAN == null ? new String() : ACCCAN;
		return ACCCAN;
	}

	public void setACCCAN(String aCCCAN) {
		ACCCAN = aCCCAN;
	}

	public String getACCDIP() {
		ACCDIP = ACCDIP == null ? new String() : ACCDIP;
		return ACCDIP;
	}

	public void setACCDIP(String aCCDIP) {
		ACCDIP = aCCDIP;
	}

	public String getACCCIU() {
		ACCCIU = ACCCIU == null ? new String() : ACCCIU;
		return ACCCIU;
	}

	public void setACCCIU(String aCCCIU) {
		ACCCIU = aCCCIU;
	}

	public String getACCEST() {
		ACCEST = ACCEST == null ? new String() : ACCEST;
		return ACCEST;
	}

	public void setACCEST(String aCCEST) {
		ACCEST = aCCEST;
	}

	public String getACCDIR() {
		ACCDIR = ACCDIR == null ? new String() : ACCDIR;
		return ACCDIR;
	}

	public void setACCDIR(String aCCDIR) {
		ACCDIR = aCCDIR;
	}

	public String getACCDIC() {
		ACCDIC = ACCDIC == null ? new String() : ACCDIC;
		return ACCDIC;
	}

	public void setACCDIC(String aCCDIC) {
		ACCDIC = aCCDIC;
	}

	public String getACCDIM() {
		ACCDIM = ACCDIM == null ? new String() : ACCDIM;
		return ACCDIM;
	}

	public void setACCDIM(String aCCDIM) {
		ACCDIM = aCCDIM;
	}

	public String getACCIDA() {
		ACCIDA = ACCIDA == null ? new String() : ACCIDA;
		return ACCIDA;
	}

	public void setACCIDA(String aCCIDA) {
		ACCIDA = aCCIDA;
	}

	public String getACCBID() {
		ACCBID = ACCBID == null ? new String() : ACCBID;
		return ACCBID;
	}

	public void setACCBID(String aCCBID) {
		ACCBID = aCCBID;
	}

	public String getACCPEP() {
		ACCPEP = ACCPEP == null ? new String() : ACCPEP;
		return ACCPEP;
	}

	public void setACCPEP(String aCCPEP) {
		ACCPEP = aCCPEP;
	}

	public String getACCPGC() {
		ACCPGC = ACCPGC == null ? new String() : ACCPGC;
		return ACCPGC;
	}

	public void setACCPGC(String aCCPGC) {
		ACCPGC = aCCPGC;
	}

	public String getACCPGM() {
		ACCPGM = ACCPGM == null ? new String() : ACCPGM;
		return ACCPGM;
	}

	public void setACCPGM(String aCCPGM) {
		ACCPGM = aCCPGM;
	}

	public String getACCTIP() {
		ACCTIP = ACCTIP == null ? new String() : ACCTIP;
		return ACCTIP;
	}

	public void setACCTIP(String aCCTIP) {
		ACCTIP = aCCTIP;
	}

	public String getACCUSC() {
		ACCUSC = ACCUSC == null ? new String() : ACCUSC;
		return ACCUSC;
	}

	public void setACCUSC(String aCCUSC) {
		ACCUSC = aCCUSC;
	}

	public String getACCUSM() {
		ACCUSM = ACCUSM == null ? new String() : ACCUSM;
		return ACCUSM;
	}

	public void setACCUSM(String aCCUSM) {
		ACCUSM = aCCUSM;
	}

	public BigDecimal getACCFEC() {
		ACCFEC = ACCFEC == null ? new BigDecimal(0) : ACCFEC;
		return ACCFEC;
	}

	public void setACCFEC(BigDecimal aCCFEC) {
		ACCFEC = aCCFEC;
	}

	public BigDecimal getACCFEM() {
		ACCFEM = ACCFEM == null ? new BigDecimal(0) : ACCFEM;
		return ACCFEM;
	}

	public void setACCFEM(BigDecimal aCCFEM) {
		ACCFEM = aCCFEM;
	}

	public BigDecimal getACCHOC() {
		ACCHOC = ACCHOC == null ? new BigDecimal(0) : ACCHOC;
		return ACCHOC;
	}

	public void setACCHOC(BigDecimal aCCHOC) {
		ACCHOC = aCCHOC;
	}

	public BigDecimal getACCHOM() {
		ACCHOM = ACCHOM == null ? new BigDecimal(0) : ACCHOM;
		return ACCHOM;
	}

	public void setACCHOM(BigDecimal aCCHOM) {
		ACCHOM = aCCHOM;
	}

	public BigDecimal getACCAD2() {
		ACCAD2 = ACCAD2 == null ? new BigDecimal(0) : ACCAD2;
		return ACCAD2;
	}

	public void setACCAD2(BigDecimal aCCAD2) {
		ACCAD2 = aCCAD2;
	}

	public BigDecimal getACCCAP() {
		ACCCAP = ACCCAP == null ? new BigDecimal(0) : ACCCAP;
		return ACCCAP;
	}

	public void setACCCAP(BigDecimal aCCCAP) {
		ACCCAP = aCCCAP;
	}

	public int getMaxLenghtIdentificacion() {
		return maxLenghtIdentificacion;
	}

	public void setMaxLenghtIdentificacion(int maxLenghtIdentificacion) {
		this.maxLenghtIdentificacion = maxLenghtIdentificacion;
	}

	public String getACCIDN() {
		ACCIDN = ACCIDN == null ? new String() : ACCIDN;
		return ACCIDN;
	}

	public void setACCIDN(String aCCIDN) {
		ACCIDN = aCCIDN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmbNacionalidadAccionistas == null) ? 0 : cmbNacionalidadAccionistas.hashCode());
		result = prime * result + ((cmbTipoIdentificacion == null) ? 0 : cmbTipoIdentificacion.hashCode());
		result = prime * result + ((montoAcciones == null) ? 0 : montoAcciones.hashCode());
		result = prime * result
				+ ((radNaturalJuridicoAccionistas == null) ? 0 : radNaturalJuridicoAccionistas.hashCode());
		result = prime * result
				+ ((txtIdentificacionAccionistas == null) ? 0 : txtIdentificacionAccionistas.hashCode());
		result = prime * result
				+ ((txtPrimerApellidoAccionistas == null) ? 0 : txtPrimerApellidoAccionistas.hashCode());
		result = prime * result + ((txtPrimerNombreAccionistas == null) ? 0 : txtPrimerNombreAccionistas.hashCode());
		result = prime * result + ((txtRazonSocialAccionistas == null) ? 0 : txtRazonSocialAccionistas.hashCode());
		result = prime * result
				+ ((txtSegundoApellidoAccionistas == null) ? 0 : txtSegundoApellidoAccionistas.hashCode());
		result = prime * result + ((txtSegundoNombreAccionistas == null) ? 0 : txtSegundoNombreAccionistas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccionistasSeccionVO other = (AccionistasSeccionVO) obj;
		if (cmbNacionalidadAccionistas == null) {
			if (other.cmbNacionalidadAccionistas != null)
				return false;
		} else if (!cmbNacionalidadAccionistas.equals(other.cmbNacionalidadAccionistas))
			return false;
		if (cmbTipoIdentificacion == null) {
			if (other.cmbTipoIdentificacion != null)
				return false;
		} else if (!cmbTipoIdentificacion.equals(other.cmbTipoIdentificacion))
			return false;
		if (montoAcciones == null) {
			if (other.montoAcciones != null)
				return false;
		} else if (!montoAcciones.equals(other.montoAcciones))
			return false;
		if (radNaturalJuridicoAccionistas == null) {
			if (other.radNaturalJuridicoAccionistas != null)
				return false;
		} else if (!radNaturalJuridicoAccionistas.equals(other.radNaturalJuridicoAccionistas))
			return false;
		if (txtIdentificacionAccionistas == null) {
			if (other.txtIdentificacionAccionistas != null)
				return false;
		} else if (!txtIdentificacionAccionistas.equals(other.txtIdentificacionAccionistas))
			return false;
		if (txtPrimerApellidoAccionistas == null) {
			if (other.txtPrimerApellidoAccionistas != null)
				return false;
		} else if (!txtPrimerApellidoAccionistas.equals(other.txtPrimerApellidoAccionistas))
			return false;
		if (txtPrimerNombreAccionistas == null) {
			if (other.txtPrimerNombreAccionistas != null)
				return false;
		} else if (!txtPrimerNombreAccionistas.equals(other.txtPrimerNombreAccionistas))
			return false;
		if (txtRazonSocialAccionistas == null) {
			if (other.txtRazonSocialAccionistas != null)
				return false;
		} else if (!txtRazonSocialAccionistas.equals(other.txtRazonSocialAccionistas))
			return false;
		if (txtSegundoApellidoAccionistas == null) {
			if (other.txtSegundoApellidoAccionistas != null)
				return false;
		} else if (!txtSegundoApellidoAccionistas.equals(other.txtSegundoApellidoAccionistas))
			return false;
		if (txtSegundoNombreAccionistas == null) {
			if (other.txtSegundoNombreAccionistas != null)
				return false;
		} else if (!txtSegundoNombreAccionistas.equals(other.txtSegundoNombreAccionistas))
			return false;
		return true;
	}

}
