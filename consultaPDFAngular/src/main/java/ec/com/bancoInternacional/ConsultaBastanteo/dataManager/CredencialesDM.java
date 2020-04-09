package ec.com.bancoInternacional.ConsultaBastanteo.dataManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import ec.com.bancoInternacional.ConsultaBastanteo.util.ApplicationManager;
import ec.com.bancoInternacional.ConsultaBastanteo.util.Constantes;
import ec.com.bancointernacional.ApplicationSecurity;

public class CredencialesDM {
	
	private static final Logger logger = Logger.getLogger(CredencialesDM.class);
	
	public Boolean validarCredenciales(String usuarioHeader, String passHeader){
		
		String usuarioCredencial = "";
		String passCredencial = "";
		try {
			usuarioCredencial = this.devolverCredencial("user");
			passCredencial = this.devolverCredencial("pass");
		} catch (Exception e) {
			logger.error(Constantes.MENSAJE_ERROR_LOG4J_PROYECTO.concat(" HA OCURRIDO UN ERROR AL OBTENER CREDENCIAL PARA VERIFICACION CON HEADER"));
			e.printStackTrace();
			return false;
		}
		
		if (StringUtils.isBlank(usuarioHeader) && StringUtils.isBlank(passHeader)) {
			logger.error(Constantes.MENSAJE_ERROR_LOG4J_PROYECTO.concat(" USUARIO O CONTRASENA HEADER NULOS"));
			return false;
		}
		
		if (StringUtils.isBlank(usuarioCredencial) && StringUtils.isBlank(passCredencial)) {
			logger.error(Constantes.MENSAJE_ERROR_LOG4J_PROYECTO.concat(" USUARIO O CONTRASENA CREDENCIAL NULOS"));
			return false;
		}
		
		if (usuarioHeader.equals(usuarioCredencial) && passHeader.equals(passCredencial)) {
			logger.info(Constantes.MENSAJE_INFO_LOG4J_PROYECTO.concat(" INGRESO A SERVICIO, AUTORIZACION POR HEADERS CORRECTA"));
			return true;
		}
		return false;
	}
	
	private String devolverCredencial (String tipo) throws IOException, NumberFormatException{
		String path = ApplicationSecurity.getString("path.archivos.as400") + ApplicationSecurity.getString("archivo.as400.enc");
		File localFile = null;
		FileReader localFileReader = null;
		//BufferedReader localBufferedReader = null;
		LineNumberReader lineNumberReader = null;
		localFile = new File(path);
		localFileReader = new FileReader(localFile);
		//localBufferedReader = new BufferedReader(localFileReader);
		lineNumberReader = new LineNumberReader(localFileReader);
		for (String line = null; (line = lineNumberReader.readLine()) != null;) {
			if (tipo.equals("user")){
				if (lineNumberReader.getLineNumber() == Integer.parseInt(ApplicationManager.getString("app.encriptado.numero.linea.usuario"))) {
					lineNumberReader.close();
					return line.substring(Integer.parseInt(ApplicationManager.getString("app.encriptado.numero.caracteres.ignorar")));
				}
			}
			if (tipo.equals("pass")){
				if (lineNumberReader.getLineNumber() == Integer.parseInt(ApplicationManager.getString("app.encriptado.numero.linea.pass"))) {
					lineNumberReader.close();
					return line.substring(Integer.parseInt(ApplicationManager.getString("app.encriptado.numero.caracteres.ignorar")));
				}
			}
		}
		lineNumberReader.close();
		return "";
	}
	

}
