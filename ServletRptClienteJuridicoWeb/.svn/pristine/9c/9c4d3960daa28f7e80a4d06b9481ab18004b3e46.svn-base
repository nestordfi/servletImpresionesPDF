package ec.com.bancoInternacional.view.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ibm.connector.as400.ConnAS;

import ec.com.bancoInternacional.config.Application;
import ec.com.bancoInternacional.config.ApplicationWeb;
import ec.com.bancoInternacional.server.seguridad.Credencial;
import ec.com.bancoInternacional.services.exception.PooledTrxException;
import ec.com.bancoInternacional.services.impl.ServiceFacadeInterface;
import ec.com.bancoInternacional.view.services.report.RptClienteJuridicoVinculacionService;
import ec.com.bancointernacional.services.common.BaseAESCipher;

public class Util implements Serializable{
	private static final long serialVersionUID = 5576910991476167950L;
	private static final Logger logger = Logger.getLogger(Util.class);
	
	private static SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MMM-dd");
	private static SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
		
	/*
	 * Desencriptador cadena
	 */
	public static String desencriptarString(String usr) {
		String keyPath = Application.getString("path.archivos.as400")
				+ Application.getString("archivo.as400.key");
		String seedPath = Application.getString("path.archivos.as400")
				+ Application.getString("archivo.as400.seed");
		BaseAESCipher aesCipher = new BaseAESCipher(keyPath, seedPath);

		return aesCipher.decryptValue(usr);
	}

	public Credencial CargarCredenciales(ServiceFacadeInterface clientService, String usuarioDesencriptado, HttpSession session) throws PooledTrxException{
		Date fechaActual = new Date();
		Credencial credencial = new Credencial(usuarioDesencriptado, session, formatofecha.format(fechaActual),
				formatoHora.format(fechaActual), fechaActual.getTime());
		return clientService.getCntrlBth(credencial);
	}
	
	/*
	 * Recuperar un pdf de una ruta en la intranet
	 */
	public static byte[] obtenerReporteIntranet(String url) throws IOException, Exception {
		URL urlObject;
		byte[] data = null;
		try {
			String usuario = ConnAS.listaParametros.get(Integer.parseInt(ApplicationWeb.getString("app.url.externos.usuario")));
			String clave = ConnAS.listaParametros.get(Integer.parseInt(ApplicationWeb.getString("app.url.externos.clave")));
			String loginPassword = ApplicationWeb.getString("app.url.externos.dominio") + "\\" + usuario + ":" + clave;
			String encoded = new sun.misc.BASE64Encoder().encode(loginPassword.getBytes());
			urlObject = new URL(url);
			URLConnection urlConnection = urlObject.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + encoded);
			InputStream inputStream = urlConnection.getInputStream();
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buf = new byte[4096];
			int n;
			while ((n = inputStream.read(buf)) >= 0)
				os.write(buf, 0, n);
			os.close();
			inputStream.close();
			data = os.toByteArray();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			logger.error("ERROR:ClientePantallaPrincipalController:obtenerReporteRemoto", ioe);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ERROR:ClientePantallaPrincipalController:obtenerReporteRemoto", e);
		}
		return data;
	}
	
	/*
	 * Obtener los bytes de una ruta local
	 */
	public static byte[] readBytesFromFile(String filePath) {
		FileInputStream fileInputStream = null;
		byte[] bytesArray = null;
		try {
			File file = new File(filePath);
			bytesArray = new byte[(int) file.length()];

			// read file into bytes[]
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bytesArray);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bytesArray;
	}
	
	/**
	 * Retorna la extension perteneciente al archivo.
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
		String extensionArchivo = "";
		int posp = 0;

		if (fileName != null) {
			posp = fileName.trim().lastIndexOf(".");
		}
		if (posp > 0) {
			extensionArchivo = fileName.substring(posp);
			extensionArchivo = extensionArchivo.toLowerCase();

		}
		return extensionArchivo;
	}
	
	public static String completarLongitud(String texto, int longitud){
		if (null==texto){
			return "";
		}
		String espacio = "";
		int longitudTexto=texto.length();
		String textoCompleto=texto;
		if (longitudTexto<longitud){
			for (int i=longitudTexto; i<longitud; i++){
				espacio+=" ";
			}
			textoCompleto+=espacio;
		}
		else{
			return truncarTexto(texto, longitud);
		}
		return textoCompleto;
	}
	
	 /**
		 * Se trunca Texto de campos al máximo permitido en base de datos 
		 * @param texto del campo 
		 * @param maxLenght longitud màxima del campo
		 * @return String truncado.
		 */
	public static String truncarTexto(String texto, int maxLenght){
		if (null==texto){
			return "";
		}
		if (texto.length()>maxLenght){
			return texto.substring(0, maxLenght);
		}
		else {
			return texto;
		}		
	}

	public static BigDecimal calcularDuracion(BigDecimal limdurOut) {
		if (null==limdurOut){
			return BigDecimal.ZERO;
		}
		if (limdurOut.compareTo(new BigDecimal("100"))>0){
			return new BigDecimal("99");
		}
		else {
			return limdurOut;
		}
	}
}
