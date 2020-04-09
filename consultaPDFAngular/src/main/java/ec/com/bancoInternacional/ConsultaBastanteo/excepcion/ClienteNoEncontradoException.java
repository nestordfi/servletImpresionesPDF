package ec.com.bancoInternacional.ConsultaBastanteo.excepcion;

/**
 * Autor:		Nestor franco
 * Objetivo:	Clase para manejo de Exception si no hay resultados  
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class ClienteNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNoEncontradoException(String message) {
		super(message);
	}

	
}
