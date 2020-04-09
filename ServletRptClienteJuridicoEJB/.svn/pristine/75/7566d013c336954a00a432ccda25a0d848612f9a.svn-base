package ec.com.bancoInternacional.services.domain;

public class EstadoCiudadModeloCatalogo {
	private String id;
	private String codigoPais;
	private String codigoDepartamento;
	private String codigoCiudad;
	private String nombre;
	
	public EstadoCiudadModeloCatalogo(){
		
	}
	
	public EstadoCiudadModeloCatalogo(String id, String codigoPais, String codigoDepartamento, String codigoCiudad, String nombre) {
		super();
		codigoPais = codigoPais != null ?  codigoPais.trim() : "";
		codigoDepartamento = codigoDepartamento != null ?  codigoDepartamento.trim() : "";
		codigoCiudad = codigoCiudad != null ?  codigoCiudad.trim() : "";
		nombre = nombre != null ?  nombre.trim() : "";
		this.id = codigoPais+codigoDepartamento+codigoCiudad;
		this.codigoPais = codigoPais;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoCiudad = codigoCiudad;
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getCodigoCiudad() {
		return codigoCiudad;
	}
	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "CiudadEcuador [id=" + id + ", codigoPais=" + codigoPais + ", codigoDepartamento=" + codigoDepartamento
				+ ", codigoCiudad=" + codigoCiudad + ", nombre=" + nombre + "]";
	}
	
}
