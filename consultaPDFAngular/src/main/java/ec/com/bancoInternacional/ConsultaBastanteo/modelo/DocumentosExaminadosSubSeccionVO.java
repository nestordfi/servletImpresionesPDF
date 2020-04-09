package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class DocumentosExaminadosSubSeccionVO implements Serializable {
	
	/**
	 * 
	 */
	// vista
	private static final long serialVersionUID = 1L;
	private String cmbConceptoDoc;
	private String txtNotaria;
	private Date dteFechaDoc;
	private Date dteFechaInscripcionDoc;
	private String radTipoDoc;

	// hidden
	
	private String hiddenDteFechaDoc;
	private String hiddenDteFechaInscripcionDoc;
	
	// ocultos

	private String DOCAD1;
	private String DOCCAN;
	private String DOCDIP;
	private String DOCDIC;
	private String DOCDIM;
	private String DOCIDN;
	private String DOCPGC;
	private String DOCPRM;
	private String DOCTID;
	private String DOCUSC;
	private String DOCUSM;

	private BigDecimal DOCFEC;
	private BigDecimal DOCFEM;
	private BigDecimal DOCHOC;
	private BigDecimal DOCHOM;
	private BigDecimal DOCSEC;

	private BigDecimal DOCAD2;
	
	public String getCmbConceptoDoc() {
		cmbConceptoDoc = cmbConceptoDoc == null ? new String() : cmbConceptoDoc.toUpperCase();
		return cmbConceptoDoc;
	}

	public void setCmbConceptoDoc(String cmbConceptoDoc) {
		this.cmbConceptoDoc = cmbConceptoDoc;
	}

	public String getTxtNotaria() {
		txtNotaria = txtNotaria == null ? new String() : txtNotaria.toUpperCase();
		return txtNotaria;
	}

	public void setTxtNotaria(String txtNotaria) {
		this.txtNotaria = txtNotaria;
	}

	public Date getDteFechaDoc() {
		return dteFechaDoc;
	}

	public void setDteFechaDoc(Date dteFechaDoc) {
		this.dteFechaDoc = dteFechaDoc;
	}

	public Date getDteFechaInscripcionDoc() {
		return dteFechaInscripcionDoc;
	}

	public void setDteFechaInscripcionDoc(Date dteFechaInscripcionDoc) {
		this.dteFechaInscripcionDoc = dteFechaInscripcionDoc;
	}

	public String getRadTipoDoc() {
		radTipoDoc = radTipoDoc == null ? new String() : radTipoDoc;
		return radTipoDoc;
	}

	public void setRadTipoDoc(String radTipoDoc) {
		this.radTipoDoc = radTipoDoc;
	}

	public String getDOCAD1() {
		DOCAD1 = DOCAD1 == null ? new String() : DOCAD1;
		return DOCAD1;
	}

	public void setDOCAD1(String dOCAD1) {
		DOCAD1 = dOCAD1;
	}

	public String getDOCCAN() {
		DOCCAN = DOCCAN == null ? new String() : DOCCAN;
		return DOCCAN;
	}

	public void setDOCCAN(String dOCCAN) {
		DOCCAN = dOCCAN;
	}

	public String getDOCDIP() {
		DOCDIP = DOCDIP == null ? new String() : DOCDIP;
		return DOCDIP;
	}

	public void setDOCDIP(String dOCDIP) {
		DOCDIP = dOCDIP;
	}

	public String getDOCDIC() {
		DOCDIC = DOCDIC == null ? new String() : DOCDIC;
		return DOCDIC;
	}

	public void setDOCDIC(String dOCDIC) {
		DOCDIC = dOCDIC;
	}

	public String getDOCDIM() {
		DOCDIM = DOCDIM == null ? new String() : DOCDIM;
		return DOCDIM;
	}

	public void setDOCDIM(String dOCDIM) {
		DOCDIM = dOCDIM;
	}

	public String getDOCIDN() {
		DOCIDN = DOCIDN == null ? new String() : DOCIDN;
		return DOCIDN;
	}

	public void setDOCIDN(String dOCIDN) {
		DOCIDN = dOCIDN;
	}

	public String getDOCPGC() {
		DOCPGC = DOCPGC == null ? new String() : DOCPGC;
		return DOCPGC;
	}

	public void setDOCPGC(String dOCPGC) {
		DOCPGC = dOCPGC;
	}

	public String getDOCPRM() {
		DOCPRM = DOCPRM == null ? new String() : DOCPRM;
		return DOCPRM;
	}

	public void setDOCPRM(String dOCPRM) {
		DOCPRM = dOCPRM;
	}

	public String getDOCTID() {
		DOCTID = DOCTID == null ? new String() : DOCTID;
		return DOCTID;
	}

	public void setDOCTID(String dOCTID) {
		DOCTID = dOCTID;
	}

	public String getDOCUSC() {
		DOCUSC = DOCUSC == null ? new String() : DOCUSC;
		return DOCUSC;
	}

	public void setDOCUSC(String dOCUSC) {
		DOCUSC = dOCUSC;
	}

	public String getDOCUSM() {
		DOCUSM = DOCUSM == null ? new String() : DOCUSM;
		return DOCUSM;
	}

	public void setDOCUSM(String dOCUSM) {
		DOCUSM = dOCUSM;
	}

	public BigDecimal getDOCFEC() {
		DOCFEC = DOCFEC == null ? new BigDecimal(0) : DOCFEC;
		return DOCFEC;
	}

	public void setDOCFEC(BigDecimal dOCFEC) {
		DOCFEC = dOCFEC;
	}

	public BigDecimal getDOCFEM() {
		DOCFEM = DOCFEM == null ? new BigDecimal(0) : DOCFEM;
		return DOCFEM;
	}

	public void setDOCFEM(BigDecimal dOCFEM) {
		DOCFEM = dOCFEM;
	}

	public BigDecimal getDOCHOC() {
		DOCHOC = DOCHOC == null ? new BigDecimal(0) : DOCHOC;
		return DOCHOC;
	}

	public void setDOCHOC(BigDecimal dOCHOC) {
		DOCHOC = dOCHOC;
	}

	public BigDecimal getDOCHOM() {
		DOCHOM = DOCHOM == null ? new BigDecimal(0) : DOCHOM;
		return DOCHOM;
	}

	public void setDOCHOM(BigDecimal dOCHOM) {
		DOCHOM = dOCHOM;
	}

	public BigDecimal getDOCSEC() {
		DOCSEC = DOCSEC == null ? new BigDecimal(0) : DOCSEC;
		return DOCSEC;
	}

	public void setDOCSEC(BigDecimal dOCSEC) {
		DOCSEC = dOCSEC;
	}

	public BigDecimal getDOCAD2() {
		DOCAD2 = DOCAD2 == null ? new BigDecimal(0) : DOCAD2;
		return DOCAD2;
	}

	public void setDOCAD2(BigDecimal dOCAD2) {
		DOCAD2 = dOCAD2;
	}

	public String getHiddenDteFechaDoc() {
		return hiddenDteFechaDoc;
	}

	public void setHiddenDteFechaDoc(String hiddenDteFechaDoc) {
		this.hiddenDteFechaDoc = hiddenDteFechaDoc;
	}

	public String getHiddenDteFechaInscripcionDoc() {
		return hiddenDteFechaInscripcionDoc;
	}

	public void setHiddenDteFechaInscripcionDoc(String hiddenDteFechaInscripcionDoc) {
		this.hiddenDteFechaInscripcionDoc = hiddenDteFechaInscripcionDoc;
	}

}
