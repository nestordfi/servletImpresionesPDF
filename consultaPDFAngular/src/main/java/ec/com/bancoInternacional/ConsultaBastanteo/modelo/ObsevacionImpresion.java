package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

public class ObsevacionImpresion {

	private String txtDescripcionObs;
	
	public String getTxtDescripcionObs() {
		return txtDescripcionObs;
	}
	public void setTxtDescripcionObs(String txtDescripcionObs) {
		this.txtDescripcionObs = txtDescripcionObs;
	}
	@Override
	public String toString() {
		return "ObsevacionImpresion [txtDescripcionObs=" + txtDescripcionObs + "]";
	}

}
