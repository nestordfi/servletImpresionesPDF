package ec.com.bancoInternacional.services.domain;

/**
 * Autor: Sandro Guevara
 * Objetivo:	Clase de dominio que representa un catalogo NCODIG 
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class Ncodig extends Catalogo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idExt = "";
	private String[] ncCod = null;
	private String[] ncVal = null;
	private String[] ncDat = null;
	
	public Ncodig(String idExt, String[] ncCod, String[] ncVal, String[] ncDat) {
		super();
		this.idExt = idExt;
		this.ncCod = ncCod;
		this.ncVal = ncVal;
		this.ncDat = ncDat;
	}
	
	public Ncodig() {

	}

	public Ncodig(String name, String value) {
		super(name, value);
		// TODO Auto-generated constructor stub
	}

	public String getIdExt() {
		return idExt;
	}
	public void setIdExt(String idExt) {
		this.idExt = idExt;
	}
	public String[] getNcCod() {
		return ncCod;
	}
	public void setNcCod(String[] ncCod) {
		this.ncCod = ncCod;
	}
	public String[] getNcVal() {
		return ncVal;
	}
	public void setNcVal(String[] ncVal) {
		this.ncVal = ncVal;
	}
	public String[] getNcDat() {
		return ncDat;
	}
	public void setNcDat(String[] ncDat) {
		this.ncDat = ncDat;
	}
	
	
}
