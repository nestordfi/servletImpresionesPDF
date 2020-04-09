package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

import java.io.Serializable;
import java.util.List;

public class ValidacionInfoAgencia implements Serializable {

	private static final long serialVersionUID = 1L;
	private int status;
	private ErrorValidacion error;
	
	private List<InfoAgencia> infoAgencia;

	public ValidacionInfoAgencia() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ErrorValidacion getError() {
		return error;
	}

	public void setError(ErrorValidacion error) {
		this.error = error;
	}

	public List<InfoAgencia> getInfoAgencia() {
		return infoAgencia;
	}

	public void setInfoAgencia(List<InfoAgencia> infoAgencia) {
		this.infoAgencia = infoAgencia;
	}

}
