package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;

public class InfContactoUbicacion implements Serializable{
	private static final long serialVersionUID = -5037591520571123640L;
	
	private String cussteOut;
	private String cumma21Out;
	private String cumma22Out;
	private String cumma31Out;
	private String cumma41Out;
	private String cumma42Out;
	private String cumma43Out;
	private String paisDomicilio;
	private String provinciaDomicilio;
	
	//NUEVO MAPEO CS0135
	private String claref1Out;//referencia
	private String cumpod21Out;//desc. Canton domicilio
	private String cumpod31Out;//des. Parroquia domicilio
	
	public InfContactoUbicacion() {
		super();
	}
	public String getPaisDomicilio() {
		return paisDomicilio;
	}

	public void setPaisDomicilio(String paisDomicilio) {
		this.paisDomicilio = paisDomicilio;
	}

	public String getProvinciaDomicilio() {
		return provinciaDomicilio;
	}

	public void setProvinciaDomicilio(String provinciaDomicilio) {
		this.provinciaDomicilio = provinciaDomicilio;
	}

	public String getCussteOut() {
		return cussteOut;
	}
	public void setCussteOut(String cussteOut) {
		this.cussteOut = cussteOut;
	}
	public String getCumma21Out() {
		return cumma21Out;
	}
	public void setCumma21Out(String cumma21Out) {
		this.cumma21Out = cumma21Out;
	}
	public String getCumma22Out() {
		return cumma22Out;
	}
	public void setCumma22Out(String cumma22Out) {
		this.cumma22Out = cumma22Out;
	}
	public String getCumma31Out() {
		return cumma31Out;
	}
	public void setCumma31Out(String cumma31Out) {
		this.cumma31Out = cumma31Out;
	}
	public String getCumma41Out() {
		return cumma41Out;
	}
	public void setCumma41Out(String cumma41Out) {
		this.cumma41Out = cumma41Out;
	}
	public String getCumma42Out() {
		return cumma42Out;
	}
	public void setCumma42Out(String cumma42Out) {
		this.cumma42Out = cumma42Out;
	}
	public String getCumma43Out() {
		return cumma43Out;
	}
	public void setCumma43Out(String cumma43Out) {
		this.cumma43Out = cumma43Out;
	}
	public String getClaref1Out() {
		return claref1Out;
	}
	public void setClaref1Out(String claref1Out) {
		this.claref1Out = claref1Out;
	}
	public String getCumpod21Out() {
		return cumpod21Out;
	}
	public void setCumpod21Out(String cumpod21Out) {
		this.cumpod21Out = cumpod21Out;
	}
	public String getCumpod31Out() {
		return cumpod31Out;
	}
	public void setCumpod31Out(String cumpod31Out) {
		this.cumpod31Out = cumpod31Out;
	}
}
