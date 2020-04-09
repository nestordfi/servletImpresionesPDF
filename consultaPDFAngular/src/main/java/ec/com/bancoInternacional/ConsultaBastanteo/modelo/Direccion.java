package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Direccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// campos ocultos
	private String DIRAD1;
	private String DIRBAR;
	private String DIRCAL;
	private String DIRCSR;
	private String DIRCAN;
	private String DIRCTP;
	private String DIRTP2;
	private String DIRCIN;
	private String DIRCI2;
	private String DIRPRE;
	private String DIRPAR;
	private String DIRCE1;
	private String DIRCE2;
	private String DIRNDE;
	private String DIRDIP;
	private String DIRDIS;
	private String DIRDIM;
	private String DIRIDN;
	private String DIRNTD;
	private String DIRTD2;
	private String DIRNCE;
	private String DIRNC2;
	private String DIRPIS;
	private String DIRNRE;
	private String DIROPE;
	private String DIROP2;
	private String DIRPRC;
	private String DIRPRM;
	private String DIRTID;
	private String DIRTRE;
	private String DIRTTL;
	private String DIRUSC;
	private String DIRUSM;

	private BigDecimal DIRAD2;
	private BigDecimal DIRFEC;
	private BigDecimal DIRFEM;
	private BigDecimal DIRHOC;
	private BigDecimal DIRHOM;
	private BigDecimal DIRSEC;

	public BigDecimal getDIRFEC() {
		DIRFEC = DIRFEC == null ? new BigDecimal(0) : DIRFEC;
		return DIRFEC;
	}

	public void setDIRFEC(BigDecimal dIRFEC) {
		DIRFEC = dIRFEC;
	}

	public BigDecimal getDIRFEM() {
		DIRFEM = DIRFEM == null ? new BigDecimal(0) : DIRFEM;
		return DIRFEM;
	}

	public void setDIRFEM(BigDecimal dIRFEM) {
		DIRFEM = dIRFEM;
	}

	public BigDecimal getDIRHOC() {
		DIRHOC = DIRHOC == null ? new BigDecimal(0) : DIRHOC;
		return DIRHOC;
	}

	public void setDIRHOC(BigDecimal dIRHOC) {
		DIRHOC = dIRHOC;
	}

	public BigDecimal getDIRHOM() {
		DIRHOM = DIRHOM == null ? new BigDecimal(0) : DIRHOM;
		return DIRHOM;
	}

	public void setDIRHOM(BigDecimal dIRHOM) {
		DIRHOM = dIRHOM;
	}

	public BigDecimal getDIRSEC() {
		DIRSEC = DIRSEC == null ? new BigDecimal(0) : DIRSEC;
		return DIRSEC;
	}

	public void setDIRSEC(BigDecimal dIRSEC) {
		DIRSEC = dIRSEC;
	}

	public BigDecimal getDIRAD2() {
		DIRAD2 = DIRAD2 == null ? new BigDecimal(0) : DIRAD2;
		return DIRAD2;
	}

	public void setDIRAD2(BigDecimal dIRAD2) {
		DIRAD2 = dIRAD2;
	}

	public String getDIRAD1() {
		DIRAD1 = DIRAD1 == null ? new String() : DIRAD1;
		return DIRAD1;
	}

	public void setDIRAD1(String dIRAD1) {
		DIRAD1 = dIRAD1;
	}

	public String getDIRBAR() {
		DIRBAR = DIRBAR == null ? new String() : DIRBAR;
		return DIRBAR;
	}

	public void setDIRBAR(String dIRBAR) {
		DIRBAR = dIRBAR;
	}

	public String getDIRCAL() {
		DIRCAL = DIRCAL == null ? new String() : DIRCAL;
		return DIRCAL;
	}

	public void setDIRCAL(String dIRCAL) {
		DIRCAL = dIRCAL;
	}

	public String getDIRCSR() {
		DIRCSR = DIRCSR == null ? new String() : DIRCSR;
		return DIRCSR;
	}

	public void setDIRCSR(String dIRCSR) {
		DIRCSR = dIRCSR;
	}

	public String getDIRCAN() {
		DIRCAN = DIRCAN == null ? new String() : DIRCAN;
		return DIRCAN;
	}

	public void setDIRCAN(String dIRCAN) {
		DIRCAN = dIRCAN;
	}

	public String getDIRCTP() {
		DIRCTP = DIRCTP == null ? new String() : DIRCTP;
		return DIRCTP;
	}

	public void setDIRCTP(String dIRCTP) {
		DIRCTP = dIRCTP;
	}

	public String getDIRTP2() {
		DIRTP2 = DIRTP2 == null ? new String() : DIRTP2;
		return DIRTP2;
	}

	public void setDIRTP2(String dIRTP2) {
		DIRTP2 = dIRTP2;
	}

	public String getDIRCIN() {
		DIRCIN = DIRCIN == null ? new String() : DIRCIN;
		return DIRCIN;
	}

	public void setDIRCIN(String dIRCIN) {
		DIRCIN = dIRCIN;
	}

	public String getDIRCI2() {
		DIRCI2 = DIRCI2 == null ? new String() : DIRCI2;
		return DIRCI2;
	}

	public void setDIRCI2(String dIRCI2) {
		DIRCI2 = dIRCI2;
	}

	public String getDIRPRE() {
		DIRPRE = DIRPRE == null ? new String() : DIRPRE;
		return DIRPRE;
	}

	public void setDIRPRE(String dIRPRE) {
		DIRPRE = dIRPRE;
	}

	public String getDIRPAR() {
		DIRPAR = DIRPAR == null ? new String() : DIRPAR;
		return DIRPAR;
	}

	public void setDIRPAR(String dIRPAR) {
		DIRPAR = dIRPAR;
	}

	public String getDIRCE1() {
		DIRCE1 = DIRCE1 == null ? new String() : DIRCE1;
		return DIRCE1;
	}

	public void setDIRCE1(String dIRCE1) {
		DIRCE1 = dIRCE1;
	}

	public String getDIRCE2() {
		DIRCE2 = DIRCE2 == null ? new String() : DIRCE2;
		return DIRCE2;
	}

	public void setDIRCE2(String dIRCE2) {
		DIRCE2 = dIRCE2;
	}

	public String getDIRNDE() {
		DIRNDE = DIRNDE == null ? new String() : DIRNDE;
		return DIRNDE;
	}

	public void setDIRNDE(String dIRNDE) {
		DIRNDE = dIRNDE;
	}

	public String getDIRDIP() {
		DIRDIP = DIRDIP == null ? new String() : DIRDIP;
		return DIRDIP;
	}

	public void setDIRDIP(String dIRDIP) {
		DIRDIP = dIRDIP;
	}

	public String getDIRDIS() {
		DIRDIS = DIRDIS == null ? new String() : DIRDIS;
		return DIRDIS;
	}

	public void setDIRDIS(String dIRDIS) {
		DIRDIS = dIRDIS;
	}

	public String getDIRDIM() {
		DIRDIM = DIRDIM == null ? new String() : DIRDIM;
		return DIRDIM;
	}

	public void setDIRDIM(String dIRDIM) {
		DIRDIM = dIRDIM;
	}

	public String getDIRIDN() {
		DIRIDN = DIRIDN == null ? new String() : DIRIDN;
		return DIRIDN;
	}

	public void setDIRIDN(String dIRIDN) {
		DIRIDN = dIRIDN;
	}

	public String getDIRNTD() {
		DIRNTD = DIRNTD == null ? new String() : DIRNTD;
		return DIRNTD;
	}

	public void setDIRNTD(String dIRNTD) {
		DIRNTD = dIRNTD;
	}

	public String getDIRTD2() {
		DIRTD2 = DIRTD2 == null ? new String() : DIRTD2;
		return DIRTD2;
	}

	public void setDIRTD2(String dIRTD2) {
		DIRTD2 = dIRTD2;
	}

	public String getDIRNCE() {
		DIRNCE = DIRNCE == null ? new String() : DIRNCE;
		return DIRNCE;
	}

	public void setDIRNCE(String dIRNCE) {
		DIRNCE = dIRNCE;
	}

	public String getDIRNC2() {
		DIRNC2 = DIRNC2 == null ? new String() : DIRNC2;
		return DIRNC2;
	}

	public void setDIRNC2(String dIRNC2) {
		DIRNC2 = dIRNC2;
	}

	public String getDIRPIS() {
		DIRPIS = DIRPIS == null ? new String() : DIRPIS;
		return DIRPIS;
	}

	public void setDIRPIS(String dIRPIS) {
		DIRPIS = dIRPIS;
	}

	public String getDIRNRE() {
		DIRNRE = DIRNRE == null ? new String() : DIRNRE;
		return DIRNRE;
	}

	public void setDIRNRE(String dIRNRE) {
		DIRNRE = dIRNRE;
	}

	public String getDIROPE() {
		DIROPE = DIROPE == null ? new String() : DIROPE;
		return DIROPE;
	}

	public void setDIROPE(String dIROPE) {
		DIROPE = dIROPE;
	}

	public String getDIROP2() {
		DIROP2 = DIROP2 == null ? new String() : DIROP2;
		return DIROP2;
	}

	public void setDIROP2(String dIROP2) {
		DIROP2 = dIROP2;
	}

	public String getDIRPRC() {
		DIRPRC = DIRPRC == null ? new String() : DIRPRC;
		return DIRPRC;
	}

	public void setDIRPRC(String dIRPRC) {
		DIRPRC = dIRPRC;
	}

	public String getDIRPRM() {
		DIRPRM = DIRPRM == null ? new String() : DIRPRM;
		return DIRPRM;
	}

	public void setDIRPRM(String dIRPRM) {
		DIRPRM = dIRPRM;
	}

	public String getDIRTID() {
		DIRTID = DIRTID == null ? new String() : DIRTID;
		return DIRTID;
	}

	public void setDIRTID(String dIRTID) {
		DIRTID = dIRTID;
	}

	public String getDIRTRE() {
		DIRTRE = DIRTRE == null ? new String() : DIRTRE;
		return DIRTRE;
	}

	public void setDIRTRE(String dIRTRE) {
		DIRTRE = dIRTRE;
	}

	public String getDIRTTL() {
		DIRTTL = DIRTTL == null ? new String() : DIRTTL;
		return DIRTTL;
	}

	public void setDIRTTL(String dIRTTL) {
		DIRTTL = dIRTTL;
	}

	public String getDIRUSC() {
		DIRUSC = DIRUSC == null ? new String() : DIRUSC;
		return DIRUSC;
	}

	public void setDIRUSC(String dIRUSC) {
		DIRUSC = dIRUSC;
	}

	public String getDIRUSM() {
		DIRUSM = DIRUSM == null ? new String() : DIRUSM;
		return DIRUSM;
	}

	public void setDIRUSM(String dIRUSM) {
		DIRUSM = dIRUSM;
	}

}
