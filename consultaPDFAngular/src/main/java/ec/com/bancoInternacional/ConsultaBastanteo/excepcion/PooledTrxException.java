package ec.com.bancoInternacional.ConsultaBastanteo.excepcion;

/**
 * Autor:		Carlos Carrera
 * Objetivo:	Clase para manejo de Exception propia de PooledTrx hacia As400 
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */
public class PooledTrxException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PooledTrxException(String message) {
		super(message);
	}

	
}
