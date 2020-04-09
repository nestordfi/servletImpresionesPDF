package ec.com.bancoInternacional.ConsultaBastanteo.modelo;

/**
 * Autor:		Sandro Guevara
 * Objetivo:	Objecto de datos default de catalogos de nacionalidades
 * Fecha:		01-02-2018
 * Nro. Req:	1546
 * Version:		1.0
 */
public class NacionalidadCatalogoVO extends CatalogoModeloVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoPais;
	public String getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

}
