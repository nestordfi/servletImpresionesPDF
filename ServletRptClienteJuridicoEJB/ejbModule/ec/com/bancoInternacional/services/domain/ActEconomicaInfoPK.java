package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

/**
 * Autor: Sandro Guevara
 * Objetivo: Clase de dominio que represeenta Datos de la clave primaria de Actividad Económica
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class ActEconomicaInfoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cciniv;
	private String ccicc1;
	private String ccicc2;
	private String ccicc3;
	private String ccicc4;
	private String ccicc5;
	private String ccicc6;

	public ActEconomicaInfoPK() {
		super();
	}

	public String getCciniv() {
		return cciniv;
	}

	public void setCciniv(String cciniv) {
		this.cciniv = cciniv;
	}

	public String getCcicc1() {
		return ccicc1;
	}

	public void setCcicc1(String ccicc1) {
		this.ccicc1 = ccicc1;
	}

	public String getCcicc2() {
		return ccicc2;
	}

	public void setCcicc2(String ccicc2) {
		this.ccicc2 = ccicc2;
	}

	public String getCcicc3() {
		return ccicc3;
	}

	public void setCcicc3(String ccicc3) {
		this.ccicc3 = ccicc3;
	}

	public String getCcicc4() {
		return ccicc4;
	}

	public void setCcicc4(String ccicc4) {
		this.ccicc4 = ccicc4;
	}

	public String getCcicc5() {
		return ccicc5;
	}

	public void setCcicc5(String ccicc5) {
		this.ccicc5 = ccicc5;
	}

	public String getCcicc6() {
		return ccicc6;
	}

	public void setCcicc6(String ccicc6) {
		this.ccicc6 = ccicc6;
	}
}
