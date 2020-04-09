package ec.com.bancoInternacional.view.services.notificacion;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.DataInputStream;
import org.apache.log4j.Logger;
import java.io.InputStreamReader;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import ec.com.bancoInternacional.view.util.Util;
import ec.com.bancoInternacional.notifica.Anexo;
import ec.com.bancoInternacional.view.util.Constantes;
import ec.com.bancoInternacional.notifica.NotificaOut;
import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.config.ApplicationWeb;
import ec.com.bancoInternacional.notifica.NotificaEmailInp;
import ec.com.bancoInternacional.notifica.NotificacionProxy;
import ec.com.bancoInternacional.services.mapping.DatosEnvioCorreo;

/**
 * Clase que se encargara de enviar la notifiacion al cliente
 * enviando los respectivos reportes.
 */
public class EnvioCorreoPdf implements Serializable{
	
	private static final long serialVersionUID = -1977378745380512437L;
	private static final Logger logger = Logger.getLogger(EnvioCorreoPdf.class);

	/**
	 * Registro los logs por cada uno de los procesos que se realizan en el 
	 * controlador de tipo ya sean de tipo Error o Info.
	 * 
	 * @param mensaje
	 * @param tipoMensaje
	 */
	private static void registrosDeLogsPorProcesos(String mensaje, String tipoMensaje){
		if(tipoMensaje.equals("INFO")){
			logger.info(mensaje);
		} else {
			logger.error(mensaje);
		}
	}
	
	/**
	 * Funcion que permitira enviar el correo con los respectivos datos adjuntos al cliente.
	 * Retornara true o false para controlar si se ha enviado la notificacion de forma correcta.
	 * 
	 * @param correoCliente
	 * @param reportesPdf
	 * @param deseaAdjuntarImagenes
	 * @param datosEnvioCorreo 
	 * @return
	 */
	public static boolean enviarCorreoConPdf(String correoCliente, byte[] reportesPdf, String deseaAdjuntarImagenes, 
			String nombreClienteJuridico, DatosEnvioCorreo datosEnvioCorreo){
		registrosDeLogsPorProcesos("Inicia el metodo enviarCorreoConPdf", "INFO");
		
		boolean finalizaProcesoSinError = true;
		
		try {
			NotificacionProxy proxy = new NotificacionProxy();
			proxy.setEndpoint(ApplicationWeb.getString("app.envio.correo.web.service"));
		
			Anexo[] archivosAEnviar = archivosAdjuntos(reportesPdf, deseaAdjuntarImagenes);
			
			if(archivosAEnviar != null){
				String from = ApplicationWeb.getString("app.envio.correo.from");
				NotificaEmailInp notificaEmailInp = null;
				NotificaOut notificaOut = null;
				notificaEmailInp = new NotificaEmailInp(correoCliente, "", null, 
						from, Constantes.ASUNTO_CORREO,
						reemplazarParametrosEnHtmlCorreo(obtenerCuerpoCorreo(), datosEnvioCorreo, nombreClienteJuridico),
						archivosAEnviar, true);
		
				notificaOut = proxy.notificaEmail(notificaEmailInp);
			}
		} catch (Exception errorEnviarCorreoConPdf) {
			registrosDeLogsPorProcesos("Ocurrio en el metodo enviarCorreoConPdf", "ERROR");
			registrosDeLogsPorProcesos(errorEnviarCorreoConPdf.getMessage(), "ERROR");
			registrosDeLogsPorProcesos("Error presentando en el metodo enviarCorreoConPdf: " + errorEnviarCorreoConPdf, "ERROR");
			finalizaProcesoSinError = false;
		}
		
		registrosDeLogsPorProcesos("Finaliza el metodo enviarCorreoConPdf", "INFO");
		
		return finalizaProcesoSinError;
	}
	
	/**
	 * Reemplaza los parametros en la plantilla del correo los cuales son los siguientes:
	 * Parametro 0 = nombre del cliente juridico.
	 * Parametro 1 = nombre asesor.
	 * Parametro 2 = nombre agencia.
	 * Parametro 3 = numero telefono asesor.
	 * 
	 * @param cuerpoCorreo
	 * @param datosEnvioCorreo
	 * @param nombreClienteJuridico
	 * @return
	 */
	private static String reemplazarParametrosEnHtmlCorreo(String cuerpoCorreo, DatosEnvioCorreo datosEnvioCorreo, 
			String nombreClienteJuridico){
		logger.info("Inicia el metodo reemplazarParametrosEnHtmlCorreo");
		
		String cuerpoCorreoSinParametros = "";
		
		cuerpoCorreoSinParametros = cuerpoCorreo.replace("#0", nombreClienteJuridico).replace("#1", datosEnvioCorreo.getNombreAsesor()).
				replace("#2", datosEnvioCorreo.getNombreAgencia()).replace("#3", ApplicationWeb.getString("app.email.numero.asesor"));
		
		logger.info("Finaliza el metodo reemplazarParametrosEnHtmlCorreo");
				
		return cuerpoCorreoSinParametros;
	}
		
	/**
	 * Retorna un arreglo del Objeto Anexo que contendra todos los archivos
	 * adjuntos en el correo.
	 * 
	 * @param reportesPdf
	 * @param deseaAdjuntarImagenes
	 * @return
	 */
	private static Anexo[] archivosAdjuntos(byte[] reportesPdf, String deseaAdjuntarImagenes){
		Anexo[] anexos = null;
		anexos = new Anexo[obtenerNumeroImagenesAdjuntas() + 1];
		
		archivoAdjunto(anexos, reportesPdf);
		if(obtenerNumeroImagenesAdjuntas() != 0 && 
				deseaAdjuntarImagenes.equals(Constantes.ADJUNTAR_IMAGENES_SI)) {
			imagenesAdjuntas(anexos);
		}
		
		return anexos;
	}
	
	/**
	 * Retorna el archivo adjunto a enviar en el correo de notificacion.
	 * 
	 * @param anexos
	 * @param reportesPdf
	 * @return
	 */
	private static Anexo[] archivoAdjunto(Anexo[] anexos, byte[] reportesPdf){
		registrosDeLogsPorProcesos("Inicia metodo archivoAdjunto", "INFO");
		
		Anexo anexo = new Anexo();
		try{
			anexo.setContenido(reportesPdf);
			anexo.setNombre(Constantes.NOMBRE_ARCHIVO_PDF);
			anexos[0] = anexo;
		} catch(Exception errorArchivoAdjunto){
			registrosDeLogsPorProcesos("Ocurrio un error en el metodo archivoAdjunto", "ERROR");
			registrosDeLogsPorProcesos(errorArchivoAdjunto.getMessage(), "ERROR");
			registrosDeLogsPorProcesos("Error presentando en el metodo archivoAdjunto: " + errorArchivoAdjunto, "ERROR");
		}
		
		registrosDeLogsPorProcesos("Finaliza metodo archivoAdjunto", "INFO");
		
		return anexos;
	}
	
	/**
	 * Retorna las imagenes adjuntas a enviar en el correo de notificacion.
	 * 
	 * @param anexos
	 * @return
	 */
	private static Anexo[] imagenesAdjuntas(Anexo[] anexos){
		registrosDeLogsPorProcesos("Inicia metodo imagenesAdjuntas", "INFO");
		
		int posicionDeImagen = 1;
		try{
			String rutasImagenes = ApplicationWeb.getString("app.imagenes.ruta");
			File file = new File(rutasImagenes);
			
			if (file.listFiles() != null) {
				for (File filesAux : file.listFiles()) {
					Anexo anexo = new Anexo();
					BufferedImage originalImage = ImageIO.read(filesAux);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					String info = Util.getExtension(filesAux.getName());
					ImageIO.write(originalImage, info.substring(1, info.length()), baos);
					anexo.setContenido(baos.toByteArray());
					anexo.setNombre("<"+ filesAux.getName() + ">");
					anexos[posicionDeImagen] = anexo;
					posicionDeImagen++;
				}
			}
		} catch (Exception errorObtenerImagenesAdjuntas){
			registrosDeLogsPorProcesos("Ocurrio un error en el metodo obtenerImagenesAdjuntas", "ERROR");
			registrosDeLogsPorProcesos(errorObtenerImagenesAdjuntas.getMessage(), "ERROR");
			registrosDeLogsPorProcesos("Error presentando en el metodo registrosDeLogsPorProcesos: " + errorObtenerImagenesAdjuntas, "ERROR");
		}
		
		registrosDeLogsPorProcesos("Finaliza metodo imagenesAdjuntas", "INFO");
		
		return anexos;
	}
	
	/**
	 * Retorna toda la estructura html de la plantilla que sera el cuerpo del correo
	 * que se le enviara al usuario.
	 * 
	 * @return
	 */
	private static String obtenerCuerpoCorreo() {
		registrosDeLogsPorProcesos("Inicia metodo obtenerCuerpoCorreo", "INFO");
		
		String plantilla = "";
		
		try {
			String rutaPlantilla = ApplicationWeb.getString("app.envio.correo.plantilla");
			
			InputStream fstream = EnvioCorreoPdf.class.getResourceAsStream(rutaPlantilla);
			DataInputStream entrada = new DataInputStream(fstream);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
			String strLinea;
			while ((strLinea = buffer.readLine()) != null) {
				plantilla = plantilla + strLinea;
			}
			buffer.close();
		} catch (Exception errorObtenerCuerpoCorreo){ 
			registrosDeLogsPorProcesos("Ocurrio un error en el metodo obtenerCuerpoCorreo", "ERROR");
			registrosDeLogsPorProcesos(errorObtenerCuerpoCorreo.getMessage(), "ERROR");
			registrosDeLogsPorProcesos("Error presentando en el metodo obtenerCuerpoCorreo: " + errorObtenerCuerpoCorreo, "ERROR");
		}
		
		registrosDeLogsPorProcesos("Finaliza metodo obtenerCuerpoCorreo", "INFO");
		
		return plantilla;
	}
	
	/**
	 * Retorna el numero de imagenes adjuntas que tendra el correo, esta cantidad
	 * la saca de una ruta especifica en el servidor.
	 * 
	 * @return
	 */
	private static int obtenerNumeroImagenesAdjuntas(){
		registrosDeLogsPorProcesos("Inicia metodo obtenerNumeroImagenesAdjuntas", "INFO");
		int numeroDeImagenes = 0;
		
		try{
			String rutasImagenes = ApplicationWeb.getString("app.imagenes.ruta");
			File file = new File(rutasImagenes);
			if (file.isDirectory()) {
				return file.listFiles().length;
			}
		} catch(Exception errorObtenerNumeroImagenesAdjuntas){
			registrosDeLogsPorProcesos("Ocurrio un error en el metodo obtenerNumeroImagenesAdjuntas", "ERROR");
			registrosDeLogsPorProcesos(errorObtenerNumeroImagenesAdjuntas.getMessage(), "ERROR");
			registrosDeLogsPorProcesos("Error presentando en el metodo obtenerNumeroImagenesAdjuntas: " + errorObtenerNumeroImagenesAdjuntas, "ERROR");
		}
		
		registrosDeLogsPorProcesos("Finaliza metodo obtenerNumeroImagenesAdjuntas", "INFO");
		
		return numeroDeImagenes;
	}
}