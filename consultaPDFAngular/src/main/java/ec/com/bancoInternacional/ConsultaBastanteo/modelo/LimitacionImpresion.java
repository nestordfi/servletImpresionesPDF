package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

public class LimitacionImpresion {

	private String txtDescripcionLim;

	public String getTxtDescripcionLim() {
		return txtDescripcionLim;
	}

	public void setTxtDescripcionLim(String txtDescripcionLim) {
		this.txtDescripcionLim = txtDescripcionLim;
	}

	@Override
	public String toString() {
		return "LimitacionImpresion [txtDescripcionLim=" + txtDescripcionLim + "]";
	}

}
