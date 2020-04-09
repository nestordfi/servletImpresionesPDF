package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.util.Arrays;

/**
 * Autor:		Carlos Carrera
 * Objetivo:	Clase de dominio que representa un catalogo NCODIG 
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
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

	@Override
	public String toString() {
		return "Ncodig [idExt=" + idExt + ", ncCod=" + Arrays.toString(ncCod) + ", ncVal=" + Arrays.toString(ncVal)
				+ ", ncDat=" + Arrays.toString(ncDat) + "]";
	}
	
	
}
