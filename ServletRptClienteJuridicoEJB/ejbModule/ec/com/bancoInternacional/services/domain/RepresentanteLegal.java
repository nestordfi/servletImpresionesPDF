package ec.com.bancoInternacional.services.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class RepresentanteLegal implements Serializable{
	private static final long serialVersionUID = -886383117520229423L;
	
	private String cumbn14Out;
	private String cumbn24Out;
	private String cumma14Out;
	private String lidnot4Out;
	private BigDecimal lidfev4Out;
	private String cumctr4Out;
	private BigDecimal cumzpc4Out;
	private String cumbms4Out;
	private String lidtt14Out;
	private String lidtt24Out;
	
	//conyuge rep legal
	private String cumma15Out;
	private String cumbni5Out;

	//direcciones rep legal
	private String cumma24Out;
	private String cumma25Out;
	private String cumma34Out;//calle secundaria
	private String cumma44Out;
	private String cumma45Out;
	private String cumma46Out;
	private String cumcty4Out;
	private String cumste4Out;
	private String lidema4out;
	
	//NUEVO MAPEO - PROGRAMA CS0135
	//direccion
	private String cummld4Out; //pais
	private String cumpod14Out; //provincia
	private String cumpod24Out; //canton
	private String cumpod34Out; //parroquia
	private String cumma2c4Out; //calle principal
	private String cumma2n4Out;	//numero calle principal
	private String cumma4b4Out; //barrio
	private String cumma4p4Out; //piso
	private String cumma4d4Out; //departamento
	private String claref4Out;  //referencia
	
	private String lidema4Out; //correo

	
	public RepresentanteLegal() {
		super();
	}

	public String getCumbn14Out() {
		return cumbn14Out;
	}

	public void setCumbn14Out(String cumbn14Out) {
		this.cumbn14Out = cumbn14Out;
	}

	public String getCumbn24Out() {
		return cumbn24Out;
	}

	public void setCumbn24Out(String cumbn24Out) {
		this.cumbn24Out = cumbn24Out;
	}

	public String getCumma14Out() {
		return cumma14Out;
	}

	public void setCumma14Out(String cumma14Out) {
		this.cumma14Out = cumma14Out;
	}

	public String getLidnot4Out() {
		return lidnot4Out;
	}

	public void setLidnot4Out(String lidnot4Out) {
		this.lidnot4Out = lidnot4Out;
	}

	public BigDecimal getLidfev4Out() {
		return lidfev4Out;
	}

	public void setLidfev4Out(BigDecimal lidfev4Out) {
		this.lidfev4Out = lidfev4Out;
	}

	public String getCumctr4Out() {
		return cumctr4Out;
	}

	public void setCumctr4Out(String cumctr4Out) {
		this.cumctr4Out = cumctr4Out;
	}

	public BigDecimal getCumzpc4Out() {
		return cumzpc4Out;
	}

	public void setCumzpc4Out(BigDecimal cumzpc4Out) {
		this.cumzpc4Out = cumzpc4Out;
	}

	public String getCumbms4Out() {
		return cumbms4Out;
	}

	public void setCumbms4Out(String cumbms4Out) {
		this.cumbms4Out = cumbms4Out;
	}

	public String getLidtt14Out() {
		return lidtt14Out;
	}

	public void setLidtt14Out(String lidtt14Out) {
		this.lidtt14Out = lidtt14Out;
	}

	public String getLidtt24Out() {
		return lidtt24Out;
	}

	public void setLidtt24Out(String lidtt24Out) {
		this.lidtt24Out = lidtt24Out;
	}

	public String getCumma15Out() {
		return cumma15Out;
	}

	public void setCumma15Out(String cumma15Out) {
		this.cumma15Out = cumma15Out;
	}

	public String getCumbni5Out() {
		return cumbni5Out;
	}

	public void setCumbni5Out(String cumbni5Out) {
		this.cumbni5Out = cumbni5Out;
	}

	public String getCumma24Out() {
		return cumma24Out;
	}

	public void setCumma24Out(String cumma24Out) {
		this.cumma24Out = cumma24Out;
	}

	public String getCumma25Out() {
		return cumma25Out;
	}

	public void setCumma25Out(String cumma25Out) {
		this.cumma25Out = cumma25Out;
	}

	public String getCumma34Out() {
		return cumma34Out;
	}

	public void setCumma34Out(String cumma34Out) {
		this.cumma34Out = cumma34Out;
	}

	public String getCumma44Out() {
		return cumma44Out;
	}

	public void setCumma44Out(String cumma44Out) {
		this.cumma44Out = cumma44Out;
	}

	public String getCumma45Out() {
		return cumma45Out;
	}

	public void setCumma45Out(String cumma45Out) {
		this.cumma45Out = cumma45Out;
	}

	public String getCumma46Out() {
		return cumma46Out;
	}

	public void setCumma46Out(String cumma46Out) {
		this.cumma46Out = cumma46Out;
	}

	public String getCumcty4Out() {
		return cumcty4Out;
	}

	public void setCumcty4Out(String cumcty4Out) {
		this.cumcty4Out = cumcty4Out;
	}

	public String getCumste4Out() {
		return cumste4Out;
	}

	public void setCumste4Out(String cumste4Out) {
		this.cumste4Out = cumste4Out;
	}

	public String getLidema4out() {
		return lidema4out;
	}

	public void setLidema4out(String lidema4out) {
		this.lidema4out = lidema4out;
	}

	public String getCummld4Out() {
		return cummld4Out;
	}

	public void setCummld4Out(String cummld4Out) {
		this.cummld4Out = cummld4Out;
	}

	public String getCumpod14Out() {
		return cumpod14Out;
	}

	public void setCumpod14Out(String cumpod14Out) {
		this.cumpod14Out = cumpod14Out;
	}

	public String getCumpod24Out() {
		return cumpod24Out;
	}

	public void setCumpod24Out(String cumpod24Out) {
		this.cumpod24Out = cumpod24Out;
	}

	public String getCumpod34Out() {
		return cumpod34Out;
	}

	public void setCumpod34Out(String cumpod34Out) {
		this.cumpod34Out = cumpod34Out;
	}

	public String getCumma2c4Out() {
		return cumma2c4Out;
	}

	public void setCumma2c4Out(String cumma2c4Out) {
		this.cumma2c4Out = cumma2c4Out;
	}

	public String getCumma2n4Out() {
		return cumma2n4Out;
	}

	public void setCumma2n4Out(String cumma2n4Out) {
		this.cumma2n4Out = cumma2n4Out;
	}

	public String getCumma4b4Out() {
		return cumma4b4Out;
	}

	public void setCumma4b4Out(String cumma4b4Out) {
		this.cumma4b4Out = cumma4b4Out;
	}

	public String getCumma4p4Out() {
		return cumma4p4Out;
	}

	public void setCumma4p4Out(String cumma4p4Out) {
		this.cumma4p4Out = cumma4p4Out;
	}

	public String getCumma4d4Out() {
		return cumma4d4Out;
	}

	public void setCumma4d4Out(String cumma4d4Out) {
		this.cumma4d4Out = cumma4d4Out;
	}

	public String getClaref4Out() {
		return claref4Out;
	}

	public void setClaref4Out(String claref4Out) {
		this.claref4Out = claref4Out;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLidema4Out() {
		return lidema4Out;
	}

	public void setLidema4Out(String lidema4Out) {
		this.lidema4Out = lidema4Out;
	}
}
