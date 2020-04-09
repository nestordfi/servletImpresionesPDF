package ec.com.bancoInternacional.view.domain;

public class RepresentanteLegalFirma {
	private String nombreApellido;
	private String cargo;
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "RepresentanteLegalFirma [nombreApellido=" + nombreApellido + ", cargo=" + cargo + "]";
	}
}
