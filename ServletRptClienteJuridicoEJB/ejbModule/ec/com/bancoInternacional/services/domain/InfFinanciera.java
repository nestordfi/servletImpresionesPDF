package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class InfFinanciera implements Serializable{
	private static final long serialVersionUID = -1079087680336087839L;

	private BigDecimal cuidi4Out;
	private BigDecimal cuitfcOut;
	private BigDecimal cuidi3Out;
	
	public InfFinanciera() {
		super();
	}
	public BigDecimal getCuidi4Out() {
		return cuidi4Out;
	}
	public void setCuidi4Out(BigDecimal cuidi4Out) {
		this.cuidi4Out = cuidi4Out;
	}
	public BigDecimal getCuitfcOut() {
		return cuitfcOut;
	}
	public void setCuitfcOut(BigDecimal cuitfcOut) {
		this.cuitfcOut = cuitfcOut;
	}
	public BigDecimal getCuidi3Out() {
		return cuidi3Out;
	}
	public void setCuidi3Out(BigDecimal cuidi3Out) {
		this.cuidi3Out = cuidi3Out;
	}

}
