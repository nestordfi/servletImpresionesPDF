package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.util.List;

public class ValidacionInfoFuncionariosPorAgencia implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	private List<ErrorValidacion> errors;
	private List<InfoFuncionario> data;

	public ValidacionInfoFuncionariosPorAgencia() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ErrorValidacion> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorValidacion> errors) {
		this.errors = errors;
	}

	public List<InfoFuncionario> getData() {
		return data;
	}

	public void setData(List<InfoFuncionario> data) {
		this.data = data;
	}

}
