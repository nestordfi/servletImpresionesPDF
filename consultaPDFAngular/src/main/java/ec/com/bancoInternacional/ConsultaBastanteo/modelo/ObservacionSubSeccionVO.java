package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Autor: Nestor Franco Objetivo: Objeto para vista - SubSeccion Observaciones
 * Fecha: 22-05-2019 Nro. Req: 1 Version: 1.0
 */
public class ObservacionSubSeccionVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String txtDescripcion;
	
	private String LIMAD1;
	private String LIMCAN;
	private String LIMDIP;
	private String LIMDIC;
	private String LIMDIM;
	private String LIMIDN;
	private String LIMPGC;
	private String LIMPRM;
	private String LIMTID;
	private String LIMTIP;
	private String LIMUSC;
	private String LIMUSM;

	private BigDecimal LIMAD2;
	private BigDecimal LIMFEC;
	private BigDecimal LIMFEM;
	private BigDecimal LIMHOC;
	private BigDecimal LIMHOM;
	private BigDecimal LIMSEC;public BigDecimal getLIMAD2() {
		LIMAD2 = LIMAD2 == null ? new BigDecimal(0) : LIMAD2;
		return LIMAD2;
	}

	public void setLIMAD2(BigDecimal lIMAD2) {
		LIMAD2 = lIMAD2;
	}

	public String getTxtDescripcion() {
		txtDescripcion = txtDescripcion == null ? new String() : txtDescripcion.toUpperCase();
		return txtDescripcion;
	}

	public void setTxtDescripcion(String txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public String getLIMAD1() {
		LIMAD1 = LIMAD1 == null ? new String() : LIMAD1;
		return LIMAD1;
	}

	public void setLIMAD1(String lIMAD1) {
		LIMAD1 = lIMAD1;
	}

	public String getLIMCAN() {
		LIMCAN = LIMCAN == null ? new String() : LIMCAN;
		return LIMCAN;
	}

	public void setLIMCAN(String lIMCAN) {
		LIMCAN = lIMCAN;
	}

	public String getLIMDIP() {
		LIMDIP = LIMDIP == null ? new String() : LIMDIP;
		return LIMDIP;
	}

	public void setLIMDIP(String lIMDIP) {
		LIMDIP = lIMDIP;
	}

	public String getLIMDIC() {
		LIMDIC = LIMDIC == null ? new String() : LIMDIC;
		return LIMDIC;
	}

	public void setLIMDIC(String lIMDIC) {
		LIMDIC = lIMDIC;
	}

	public String getLIMDIM() {
		LIMDIM = LIMDIM == null ? new String() : LIMDIM;
		return LIMDIM;
	}

	public void setLIMDIM(String lIMDIM) {
		LIMDIM = lIMDIM;
	}

	public String getLIMIDN() {
		LIMIDN = LIMIDN == null ? new String() : LIMIDN;
		return LIMIDN;
	}

	public void setLIMIDN(String lIMIDN) {
		LIMIDN = lIMIDN;
	}

	public String getLIMPGC() {
		LIMPGC = LIMPGC == null ? new String() : LIMPGC;
		return LIMPGC;
	}

	public void setLIMPGC(String lIMPGC) {
		LIMPGC = lIMPGC;
	}

	public String getLIMPRM() {
		LIMPRM = LIMPRM == null ? new String() : LIMPRM;
		return LIMPRM;
	}

	public void setLIMPRM(String lIMPRM) {
		LIMPRM = lIMPRM;
	}

	public String getLIMTID() {
		LIMTID = LIMTID == null ? new String() : LIMTID;
		return LIMTID;
	}

	public void setLIMTID(String lIMTID) {
		LIMTID = lIMTID;
	}

	public String getLIMTIP() {
		LIMTIP = LIMTIP == null ? new String() : LIMTIP;
		return LIMTIP;
	}

	public void setLIMTIP(String lIMTIP) {
		LIMTIP = lIMTIP;
	}

	public String getLIMUSC() {
		LIMUSC = LIMUSC == null ? new String() : LIMUSC;
		return LIMUSC;
	}

	public void setLIMUSC(String lIMUSC) {
		LIMUSC = lIMUSC;
	}

	public String getLIMUSM() {
		LIMUSM = LIMUSM == null ? new String() : LIMUSM;
		return LIMUSM;
	}

	public void setLIMUSM(String lIMUSM) {
		LIMUSM = lIMUSM;
	}

	public BigDecimal getLIMFEC() {
		LIMFEC = LIMFEC == null ? new BigDecimal(0) : LIMFEC;
		return LIMFEC;
	}

	public void setLIMFEC(BigDecimal lIMFEC) {
		LIMFEC = lIMFEC;
	}

	public BigDecimal getLIMFEM() {
		LIMFEM = LIMFEM == null ? new BigDecimal(0) : LIMFEM;
		return LIMFEM;
	}

	public void setLIMFEM(BigDecimal lIMFEM) {
		LIMFEM = lIMFEM;
	}

	public BigDecimal getLIMHOC() {
		LIMHOC = LIMHOC == null ? new BigDecimal(0) : LIMHOC;
		return LIMHOC;
	}

	public void setLIMHOC(BigDecimal lIMHOC) {
		LIMHOC = lIMHOC;
	}

	public BigDecimal getLIMHOM() {
		LIMHOM = LIMHOM == null ? new BigDecimal(0) : LIMHOM;
		return LIMHOM;
	}

	public void setLIMHOM(BigDecimal lIMHOM) {
		LIMHOM = lIMHOM;
	}

	public BigDecimal getLIMSEC() {
		LIMSEC = LIMSEC == null ? new BigDecimal(0) : LIMSEC;
		return LIMSEC;
	}

	public void setLIMSEC(BigDecimal lIMSEC) {
		LIMSEC = lIMSEC;
	}

}
