package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

public class Identificacion implements Serializable{
	private static final long serialVersionUID = -4009355261026425366L;

	private String cusid1Out;
	private String cusid2Out;
	private String cusna1Out;
		
	public Identificacion() {
		super();
	}
	public String getCusid1Out() {
		return cusid1Out;
	}
	public void setCusid1Out(String cusid1Out) {
		this.cusid1Out = cusid1Out;
	}
	public String getCusid2Out() {
		return cusid2Out;
	}
	public void setCusid2Out(String cusid2Out) {
		this.cusid2Out = cusid2Out;
	}
	public String getCusna1Out() {
		return cusna1Out;
	}
	public void setCusna1Out(String cusna1Out) {
		this.cusna1Out = cusna1Out;
	}
}
