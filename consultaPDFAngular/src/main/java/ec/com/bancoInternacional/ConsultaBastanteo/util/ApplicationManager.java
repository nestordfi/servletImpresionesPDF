package ec.com.bancoInternacional.ConsultaBastanteo.util;

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
 
public class ApplicationManager
{
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ApplicationManager.class);
	
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "applicationManager"; //$NON-NLS-1$

	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
    
    /** The Constant SEPARADOR. */
    private static final String SEPARADOR = "&param";
    
    /**
     * Instantiates a new application.
     */
	private ApplicationManager() {
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
     * su perzonalizaci�n con los par�metros adicionales enviados.
     * 
     * @param key the key
     * @param parameters the parameters
     * 
     * @return the string
     */
    public String getString(String key, String... parameters) {
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
    
//    private static Integer obtenerEntero(String key)
//    {
//    	Integer retorno = new Integer(-1);
//    	try
//    	{
//    		retorno = Integer.valueOf(getString(key));
//    	}
//    	catch(NumberFormatException nfe)
//    	{
//    		logger.error("Error al cargar la propiedad: ".concat(key),nfe);
//    	}
//    	return retorno;
//    }
    
}

