package ec.com.bancoInternacional.server.config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.server.util.Catalogos;

public class LoadInitInfo extends HttpServlet {
	private static final long serialVersionUID = 4001233819823388632L;
	private static final Logger logger = Logger.getLogger(LoadInitInfo.class);
	
	public static final Catalogos catalogos = new Catalogos();
	
	@Override
	public void init() throws ServletException {
		super.init();
		logger.debug("...inicia catálogos...");
		catalogos.cargaCatalogos();
		logger.debug("...inicia combos...");
		catalogos.cargarCombos();
	}//init

}//fin de la clase