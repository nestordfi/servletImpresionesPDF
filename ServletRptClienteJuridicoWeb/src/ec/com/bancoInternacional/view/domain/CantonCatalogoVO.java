package ec.com.bancoInternacional.view.domain;

/**
 * Autor: Sandro Guevara
 * Objetivo: Dto de la vista para canton
 * Fecha: 08-05-2018 
 * Nro. Req: 1605 
 * Version: 1.0
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
