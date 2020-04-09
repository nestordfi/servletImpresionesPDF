package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

public class InfReferenciaPrincipalCliente implements Serializable{
	private static final long serialVersionUID = -8571080625330576958L;
	
	private String coccpnOut;
	private String coccpiOut;
	private String coccp2Out;
	private String coccpmOut;
	
	public InfReferenciaPrincipalCliente() {
		super();
	}

	public String getCoccpnOut() {
		return coccpnOut;
	}

	public void setCoccpnOut(String coccpnOut) {
		this.coccpnOut = coccpnOut;
	}

	public String getCoccpiOut() {
		return coccpiOut;
	}

	public void setCoccpiOut(String coccpiOut) {
		this.coccpiOut = coccpiOut;
	}

	public String getCoccp2Out() {
		return coccp2Out;
	}

	public void setCoccp2Out(String coccp2Out) {
		this.coccp2Out = coccp2Out;
	}

	public String getCoccpmOut() {
		return coccpmOut;
	}

	public void setCoccpmOut(String coccpmOut) {
		this.coccpmOut = coccpmOut;
	}


}
