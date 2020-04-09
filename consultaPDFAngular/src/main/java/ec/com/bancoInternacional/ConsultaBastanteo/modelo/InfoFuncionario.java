package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class InfoFuncionario implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal agencia;
	private String codFuncionario;
	private String nombreFuncionario;
	public String codJefeAgencia;
	public String nombreJefeAgencia;

	public InfoFuncionario() {
		super();
	}

	public BigDecimal getAgencia() {
		return agencia;
	}

	public void setAgencia(BigDecimal agencia) {
		this.agencia = agencia;
	}

	public String getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(String codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public String getNombreFuncionario() {
		return nombreFuncionario;
	}

	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

	public String getCodJefeAgencia() {
		return codJefeAgencia;
	}

	public void setCodJefeAgencia(String codJefeAgencia) {
		this.codJefeAgencia = codJefeAgencia;
	}

	public String getNombreJefeAgencia() {
		return nombreJefeAgencia;
	}

	public void setNombreJefeAgencia(String nombreJefeAgencia) {
		this.nombreJefeAgencia = nombreJefeAgencia;
	}

}
