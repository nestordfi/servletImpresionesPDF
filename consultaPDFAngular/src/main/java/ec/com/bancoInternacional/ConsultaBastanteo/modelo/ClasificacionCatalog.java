package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

public class ClasificacionCatalog {
	private String id;
	private String nombre;
	private Boolean hayMinimoDeAccionista = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getHayMinimoDeAccionista() {
		return hayMinimoDeAccionista;
	}
	public void setHayMinimoDeAccionista(Boolean hayMinimoDeAccionista) {
		this.hayMinimoDeAccionista = hayMinimoDeAccionista;
	}
}
