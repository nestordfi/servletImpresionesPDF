package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

/**
 * Autor:		Sandro Guevara
 * Objetivo:	Objecto de datos default de catalogos de cantones
 * Fecha:		11-01-2018
 * Nro. Req:	1546
 * Version:		1.0
 */
public class CantonCatalogoVO extends CatalogoModeloVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provinceName;
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}
