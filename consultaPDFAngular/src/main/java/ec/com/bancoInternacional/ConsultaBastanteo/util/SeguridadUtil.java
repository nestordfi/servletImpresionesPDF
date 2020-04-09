package ec.com.bancoInternacional.ConsultaBastanteo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ec.com.bancointernacional.ApplicationSecurity;
import ec.com.bancointernacional.services.common.BaseAESCipher;

public class SeguridadUtil {

	public static String encriptar(String texto) throws UnsupportedEncodingException {
		String rutaEncriptados = ApplicationSecurity.getString("path.archivos.as400");
		String keyPath = ApplicationSecurity.getString("archivo.as400.key");
		String seedPath = ApplicationSecurity.getString("archivo.as400.seed");
		BaseAESCipher aesCipher = new BaseAESCipher(rutaEncriptados+keyPath, rutaEncriptados+seedPath);
		String textoCifrado = aesCipher.encryptValue(texto);	
		return URLEncoder.encode(textoCifrado, "UTF-8");
	}
}