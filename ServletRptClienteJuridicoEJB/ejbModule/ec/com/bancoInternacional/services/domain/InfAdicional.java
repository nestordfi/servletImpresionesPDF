package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class InfAdicional implements Serializable{
	private static final long serialVersionUID = -4617644615683812120L;
	
	private String cocctlOut;
	private String cocnolOut;
	private BigDecimal spiseq1Out;
	private String spidsc1Out;
	
	public InfAdicional() {
		super();
	}

	public String getCocctlOut() {
		return cocctlOut;
	}

	public void setCocctlOut(String cocctlOut) {
		this.cocctlOut = cocctlOut;
	}

	public String getCocnolOut() {
		return cocnolOut;
	}

	public void setCocnolOut(String cocnolOut) {
		this.cocnolOut = cocnolOut;
	}

	public BigDecimal getSpiseq1Out() {
		return spiseq1Out;
	}

	public void setSpiseq1Out(BigDecimal spiseq1Out) {
		this.spiseq1Out = spiseq1Out;
	}

	public String getSpidsc1Out() {
		return spidsc1Out;
	}

	public void setSpidsc1Out(String spidsc1Out) {
		this.spidsc1Out = spidsc1Out;
	}


}
