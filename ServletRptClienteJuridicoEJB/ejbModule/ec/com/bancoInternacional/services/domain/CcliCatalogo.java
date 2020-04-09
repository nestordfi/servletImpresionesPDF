package ec.com.bancoInternacional.services.domain;

import java.math.BigDecimal;

/**
 * Autor: Sandro Guevara
 * Objetivo:	Clase de dominio para catalogos del Tipo CCLI
 * Catalogos de NCODIG, que se recuperan mediante el programa de servicio PRCONSNCODI de cs0052 
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */

public class CcliCatalogo extends Catalogo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nccod1;
	private String nccod2;
	private String nccod3;
	private String nccod4;
	private String nccod5;
	private String ncdat1;
	private String ncdat2;
	private String ncdat3;
	private String ncdesc;
	private String ncdisp;
	private String ncesta;
	private BigDecimal ncfecr;
	private BigDecimal ncnive;
	private BigDecimal ncnivl;
	private String nctabl;
	private BigDecimal nctime;
	private String ncuser;
	private BigDecimal ncval1;
	private BigDecimal ncval2;
	private BigDecimal ncval3;
	
	public CcliCatalogo() {
		super();
	}

	public String getNccod1() {
		return nccod1;
	}
	public void setNccod1(String nccod1) {
		this.nccod1 = nccod1;
	}
	public String getNccod2() {
		return nccod2;
	}
	public void setNccod2(String nccod2) {
		this.nccod2 = nccod2;
	}
	public String getNccod3() {
		return nccod3;
	}
	public void setNccod3(String nccod3) {
		this.nccod3 = nccod3;
	}
	public String getNccod4() {
		return nccod4;
	}
	public void setNccod4(String nccod4) {
		this.nccod4 = nccod4;
	}
	public String getNccod5() {
		return nccod5;
	}
	public void setNccod5(String nccod5) {
		this.nccod5 = nccod5;
	}
	public String getNcdat1() {
		return ncdat1;
	}
	public void setNcdat1(String ncdat1) {
		this.ncdat1 = ncdat1;
	}
	public String getNcdat2() {
		return ncdat2;
	}
	public void setNcdat2(String ncdat2) {
		this.ncdat2 = ncdat2;
	}
	public String getNcdat3() {
		return ncdat3;
	}
	public void setNcdat3(String ncdat3) {
		this.ncdat3 = ncdat3;
	}
	public String getNcdesc() {
		return ncdesc;
	}
	public void setNcdesc(String ncdesc) {
		this.ncdesc = ncdesc;
	}
	public String getNcdisp() {
		return ncdisp;
	}
	public void setNcdisp(String ncdisp) {
		this.ncdisp = ncdisp;
	}
	public String getNcesta() {
		return ncesta;
	}
	public void setNcesta(String ncesta) {
		this.ncesta = ncesta;
	}
	public BigDecimal getNcfecr() {
		return ncfecr;
	}
	public void setNcfecr(BigDecimal ncfecr) {
		this.ncfecr = ncfecr;
	}
	public BigDecimal getNcnive() {
		return ncnive;
	}
	public void setNcnive(BigDecimal ncnive) {
		this.ncnive = ncnive;
	}
	public BigDecimal getNcnivl() {
		return ncnivl;
	}
	public void setNcnivl(BigDecimal ncnivl) {
		this.ncnivl = ncnivl;
	}
	public String getNctabl() {
		return nctabl;
	}
	public void setNctabl(String nctabl) {
		this.nctabl = nctabl;
	}
	public BigDecimal getNctime() {
		return nctime;
	}
	public void setNctime(BigDecimal nctime) {
		this.nctime = nctime;
	}
	public String getNcuser() {
		return ncuser;
	}
	public void setNcuser(String ncuser) {
		this.ncuser = ncuser;
	}
	public BigDecimal getNcval1() {
		return ncval1;
	}
	public void setNcval1(BigDecimal ncval1) {
		this.ncval1 = ncval1;
	}
	public BigDecimal getNcval2() {
		return ncval2;
	}
	public void setNcval2(BigDecimal ncval2) {
		this.ncval2 = ncval2;
	}
	public BigDecimal getNcval3() {
		return ncval3;
	}
	public void setNcval3(BigDecimal ncval3) {
		this.ncval3 = ncval3;
	}
	public String catalogToString(){
		String datos="";
		if(this.getNcdat1()!=null&&this.getNcdat2()!=null&&this.getNcdat3()!=null){
			datos=this.getNcdat1().concat(this.getNcdat2()).concat(this.getNcdat3());
		}
		return datos;
	}
}
