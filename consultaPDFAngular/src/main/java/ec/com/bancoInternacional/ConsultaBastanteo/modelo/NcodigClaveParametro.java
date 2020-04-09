package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

/**
 * Autor:		Carlos Carrera, 
 * Objetivo:	Clase que encapsula los parametros de consulta de NCODIG, 
 * cuando los archivos tienen calves compuestas. 
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class NcodigClaveParametro {
	
	private boolean isNcCod;
	private boolean isNcVal;
	private boolean isNcDat;
	private boolean keyExt;
	private int[] cClaves;




	public NcodigClaveParametro(boolean isNcCod, boolean isNcVal, boolean isNcDat, boolean keyExt,
			int...cClaves) {
		
		this.isNcCod = isNcCod;
		this.isNcVal = isNcVal;
		this.isNcDat = isNcDat;
		this.keyExt = keyExt;
		this.cClaves = cClaves;
	}



	public boolean isNcCod() {
		return isNcCod;
	}

	public void setNcCod(boolean isNcCod) {
		this.isNcCod = isNcCod;
	}

	public boolean isNcVal() {
		return isNcVal;
	}

	public void setNcVal(boolean isNcVal) {
		this.isNcVal = isNcVal;
	}

	public boolean isNcDat() {
		return isNcDat;
	}

	public void setNcDat(boolean isNcDat) {
		this.isNcDat = isNcDat;
	}

	public boolean isKeyExt() {
		return keyExt;
	}

	public void setKeyExt(boolean keyExt) {
		this.keyExt = keyExt;
	}

	public int[] getcClaves() {
		return cClaves;
	}

	public void setcClaves(int[] cClaves) {
		this.cClaves = cClaves;
	}

}