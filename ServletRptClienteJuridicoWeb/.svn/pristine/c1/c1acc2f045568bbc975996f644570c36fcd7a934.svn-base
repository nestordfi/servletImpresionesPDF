package ec.com.bancoInternacional.config;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
/**
 * Autor:		Carlos Carrera
 * Objetivo:	Provee acceso a los mensajes, textos, descripciones, propiedades externalizadas comunes en el sitio.
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */

public class ApplicationWeb
{
	private static final Logger logger = Logger.getLogger(ApplicationWeb.class);
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "ec.com.bancoInternacional.config.applicationWeb"; //$NON-NLS-1$

	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
    
    /** The Constant SEPARADOR. */
    private static final String SEPARADOR = "&param";

    public static final String RUTA_REPORTES = getString("app.reportes.ruta");
    /**
     * Instantiates a new application.
     */
	private ApplicationWeb() {
	}

	/**
	 * Gets the string.
	 * Recupera la propiedad referente al key pasado
	 * 
	 * @param key the key
	 * 
	 * @return the string
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

    /**
     * Gets the string.
     * Recupera la propiedad referente al key pasado complmentada
     * su perzonalización con los parámetros adicionales enviados.
     * 
     * @param key the key
     * @param parameters the parameters
     * 
     * @return the string
     */
    public static String getString(String key, String... parameters) {
        try {
            String message = "";
            String[] partsMessage = RESOURCE_BUNDLE.getString(key)
                                                   .split(SEPARADOR);

            for (String part : partsMessage) {
                try {
                    int indice = Integer.parseInt(part);

                    if (parameters.length > indice) {
                        message = message.concat(parameters[indice]);
                    }
                } catch (NumberFormatException e) {
                    message = message.concat(part);
                }
            }

            return message;
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
    
    private static 	Integer obtenerEntero(String key)
    {
    	Integer retorno = new Integer(-1);
    	try
    	{
    		retorno = Integer.valueOf(getString(key));
    	}
    	catch(NumberFormatException nfe)
    	{
    		logger.error("Error al cargar la propiedad: ".concat(key),nfe);
    	}
    	return retorno;
    }
}

