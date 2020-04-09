package ec.com.bancoInternacional.services.util;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Autor: Sandro Guevara
 * Objetivo: Clase que encapsula los parametros de entrada para Actividad Económica de clientes
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
 */
public class ClientActEconimicaParameter  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ipadress;
	private String ipcanal;
	private BigDecimal ipcodibs;
	private String ipcodidn;
	private String ipusrbin;
	public ClientActEconimicaParameter() {
		super();
	}
	public String getIpadress() {
		return ipadress;
	}
	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}
	public String getIpcanal() {
		return ipcanal;
	}
	public void setIpcanal(String ipcanal) {
		this.ipcanal = ipcanal;
	}
	public BigDecimal getIpcodibs() {
		return ipcodibs;
	}
	public void setIpcodibs(BigDecimal ipcodibs) {
		this.ipcodibs = ipcodibs;
	}
	public String getIpcodidn() {
		return ipcodidn;
	}
	public void setIpcodidn(String ipcodidn) {
		this.ipcodidn = ipcodidn;
	}
	public String getIpusrbin() {
		return ipusrbin;
	}
	public void setIpusrbin(String ipusrbin) {
		this.ipusrbin = ipusrbin;
	}
	
	
}
