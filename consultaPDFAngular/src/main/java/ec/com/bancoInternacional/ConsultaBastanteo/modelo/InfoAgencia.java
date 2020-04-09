package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class InfoAgencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal codigoAgencia;
	private BigDecimal codigoProvincia;
	private String nombreAgencia;
	private String jefeAgencia;

	public InfoAgencia() {
		super();
	}

	public BigDecimal getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(BigDecimal codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public BigDecimal getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(BigDecimal codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getNombreAgencia() {
		return nombreAgencia;
	}

	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}

	public String getJefeAgencia() {
		return jefeAgencia;
	}

	public void setJefeAgencia(String jefeAgencia) {
		this.jefeAgencia = jefeAgencia;
	}

}
