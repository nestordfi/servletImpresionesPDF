package ec.com.bancoInternacional.config;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
/**
 * Autor:		Carlos Carrera
 * Objetivo:	Provee acceso a los mensajes, textos, descripciones, propiedades externalizadas comunes en el sitio.
 * Fecha:		22-12-2017
 * Nro. Req:	1546
 * Version:		1.0
 */

public class Application
{
	private static Logger logger = Logger.getLogger(Application.class);
	
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "ec.com.bancoInternacional.config.application"; //$NON-NLS-1$

	/** The Constant RESOURCE_BUNDLE. */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);
    
    /** The Constant SEPARADOR. */
    private static final String SEPARADOR = "&param";
    
    public static final String COD_EXT_RESPUESTA_EJECUCION_HORA = getString("app.codigo.extranjeria.respuesta.ejecucion.hora");
    public static final String COD_EXT_RESPUESTA_EJECUCION_MINUTO = getString("app.codigo.extranjeria.respuesta.ejecucion.minuto");
    public static final String COD_EXT_RESPUESTA_EJECUCION_SEGUNDO = getString("app.codigo.extranjeria.respuesta.ejecucion.segundo");
    public static final String COD_EXT_NOMBRE_ARCHIVO_PROCESAR = getString("app.codigo.extranjeria.respuesta.nombre.archivo.procesar");
    public static final String COD_EXT_SIGNO_INICIO_COD_SB = getString("app.codigo.extranjeria.respuesta.signo.inicio.codigo.superBancos");
    public static final String COD_EXT_SIGNO_FIN_COD_SB = getString("app.codigo.extranjeria.respuesta.signo.fin.codigo.superBancos");
    public static final String COD_EXT_TOKEN_INICIO_LINEA = getString("app.codigo.extranjeria.respuesta.linea.inicio.token");
    public static final String COD_EXT_RESPUESTA_REPORTE_RUTA = getString("app.codigo.extranjeria.respuesta.reporte.ruta");
    public static final String COD_EXT_RESPUESTA_REPORTE_TITULO = getString("app.codigo.extranjeria.respuesta.reporte.titulo");
    public static final String COD_EXT_RESPUESTA_REPORTE_SUBTITULO_CORRECTOS = getString("app.codigo.extranjeria.respuesta.reporte.subTituloCorrectos");
    public static final String COD_EXT_RESPUESTA_REPORTE_SUBTITULO_INCORRECTOS = getString("app.codigo.extranjeria.respuesta.reporte.subTituloIncorrectos");
    public static final String COD_EXT_RESPUESTA_REPORTE_NOMBRE_ARCHIVO = getString("app.codigo.extranjeria.respuesta.reporte.nombreArchivo");
    public static final String COD_EXT_RESPUESTA_REPORTE_CABECERA_TOKEN = getString("app.codigo.extranjeria.respuesta.cabecera.token");
    public static final String COD_EXT_RESPUESTA_REPORTE_CABECERA_TITULO = getString("app.codigo.extranjeria.respuesta.cabecera.titulo");
    private static final String SEPARADOR_CODIGO_ACTIVIDAD_ECONOMICA = getString("app.separador.codigo.actividad.economica");
    public static final List<Integer> SEPARACION_CODIGO_ACTIVIDAD_ECONOMICA = separarTokens(SEPARADOR_CODIGO_ACTIVIDAD_ECONOMICA,"app.separacion.codigo.actividad.economica");
    
    /**
     * Instantiates a new application.
     */
	private Application() {
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
        /**
         * 
         * @param separado
         * @param key
         * @return
         */
        private static List<Integer> separarTokens(String separador,String key)
        {
        	List<Integer> retorno = new ArrayList<>();
        	String listaPosiciones = getString(key);
        	StringTokenizer st = new StringTokenizer(listaPosiciones,separador);
        	while(st.hasMoreTokens())
        	{
        		String aux = st.nextToken();
        		try
        		{
        			Integer pos = Integer.valueOf(aux);
        			retorno.add(pos);
        		}
        		catch(NumberFormatException nfe)
        		{
        			logger.error("Error:Application:separarTokens",nfe);
        		}
        	}
        	if(retorno.size() < 1)
        	{
        		retorno.add(0);
        	}
        	return retorno;
        }
}

