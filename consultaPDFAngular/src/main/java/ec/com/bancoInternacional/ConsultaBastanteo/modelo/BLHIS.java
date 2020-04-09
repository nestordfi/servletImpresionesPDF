package ec.com.bancoInternacional.ConsultaBastanteo.modelo;



import java.math.BigDecimal;
import java.util.Date;

public class BLHIS {
	
	private String HISTID;
	private String HISIDN;
	private Date HISFEC;
	private String HISEST;
	private String HISCAN;
	private String HISNIP;
	private String HISUSR;
	private String HISAGE;
	private Integer HISBRN;
	private String HISRAZ;
	private BigDecimal HIRCUN;
	private String HISDAT;
	
	private String nombreResponsable;
	
	public String getNombreResponsable() {
		return nombreResponsable == null ? new String() : nombreResponsable;
	}
	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}
	public String getHISTID() {
		return HISTID == null ? new String() : HISTID;
	}
	public void setHISTID(String hISTID) {
		HISTID = hISTID;
	}
	public String getHISIDN() {
		return HISIDN == null ? new String() : HISIDN;
	}
	public void setHISIDN(String hISIDN) {
		HISIDN = hISIDN;
	}
	public Date getHISFEC() {
		return HISFEC == null ? new Date() : HISFEC;
	}
	public void setHISFEC(Date hISFEC) {
		HISFEC = hISFEC;
	}
	public String getHISEST() {
		return HISEST == null ? new String() : HISEST;
	}
	public void setHISEST(String hISEST) {
		HISEST = hISEST;
	}
	public String getHISCAN() {
		return HISCAN == null ? new String() : HISCAN;
	}
	public void setHISCAN(String hISCAN) {
		HISCAN = hISCAN;
	}
	public String getHISNIP() {
		return HISNIP == null ? new String() : HISNIP;
	}
	public void setHISNIP(String hISNIP) {
		HISNIP = hISNIP;
	}
	public String getHISUSR() {
		return HISUSR == null ? new String() : HISUSR;
	}
	public void setHISUSR(String hISUSR) {
		HISUSR = hISUSR;
	}
	public String getHISAGE() {
		return HISAGE == null ? new String() : HISAGE;
	}
	public void setHISAGE(String hISAGE) {
		HISAGE = hISAGE;
	}
	public Integer getHISBRN() {
		return HISBRN == null ? new Integer(0) : HISBRN;
	}
	public void setHISBRN(Integer hISBRN) {
		HISBRN = hISBRN;
	}
	public String getHISRAZ() {
		return HISRAZ == null ? new String() : HISRAZ;
	}
	public void setHISRAZ(String hISRAZ) {
		HISRAZ = hISRAZ;
	}
	public BigDecimal getHIRCUN() {
		return HIRCUN == null ? new BigDecimal(0.0) : HIRCUN;
	}
	public void setHIRCUN(BigDecimal hIRCUN) {
		HIRCUN = hIRCUN;
	}
	public String getHISDAT() {
		return HISDAT;
	}
	public void setHISDAT(String hISDAT) {
		HISDAT = hISDAT;
	}
	
}
