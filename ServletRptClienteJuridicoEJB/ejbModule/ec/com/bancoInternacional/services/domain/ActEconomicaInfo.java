package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Autor: Sandro Guevara
 * Objetivo: Clase de dominio que represeenta Datos de la Actividad Económica
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class ActEconomicaInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private ActEconomicaInfoPK id;
	private String ccides;
	private String ccicac;
	private String ccicin;
	private String cciest;
	private String cciter;
	private String cciusr;
	private BigDecimal ccifec;
	private BigDecimal ccihor;
	
	private String ccides2;
	public String getCcides2() {
		return ccides.length() >=20 ? ccides.substring(0,20).concat("..."): ccides;
	}
	
	public ActEconomicaInfo() {
		super();
	}
	
	public String getCcides() {
		return ccides;
	}

	public void setCcides(String ccides) {
		this.ccides = ccides;
	}

	public String getCcicac() {
		return ccicac;
	}

	public void setCcicac(String ccicac) {
		this.ccicac = ccicac;
	}

	public String getCcicin() {
		return ccicin;
	}

	public void setCcicin(String ccicin) {
		this.ccicin = ccicin;
	}

	public String getCciest() {
		return cciest;
	}

	public void setCciest(String cciest) {
		this.cciest = cciest;
	}

	public String getCciter() {
		return cciter;
	}

	public void setCciter(String cciter) {
		this.cciter = cciter;
	}

	public String getCciusr() {
		return cciusr;
	}

	public void setCciusr(String cciusr) {
		this.cciusr = cciusr;
	}

	public BigDecimal getCcifec() {
		return ccifec;
	}

	public void setCcifec(BigDecimal ccifec) {
		this.ccifec = ccifec;
	}

	public BigDecimal getCcihor() {
		return ccihor;
	}

	public void setCcihor(BigDecimal ccihor) {
		this.ccihor = ccihor;
	}

	public ActEconomicaInfoPK getId() {
		return id;
	}

	public void setId(ActEconomicaInfoPK id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public String toString() {
	
		return  getId().getCciniv().concat("|") +
				getId().getCcicc1().concat("|") +
				getId().getCcicc2().concat("|") +
				getId().getCcicc3().concat("|") +
				getId().getCcicc4().concat("|") +
				getId().getCcicc5().concat("|") +
				getId().getCcicc6().concat("|") +
				getCcides().concat("|") +
				getCcicac().concat("|") +
				getCcicin().concat("|") +
				getCciest().concat("|") +
				getCciter().concat("|") +
				getCciusr().concat("|") +
				getCcifec().toString().concat("|") +
				getCcihor().toString();
		
	}

	
	
}
