package ec.com.bancoInternacional.servlet.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import ec.com.bancoInternacional.config.ApplicationWeb;
import ec.com.bancoInternacional.exception.GenerarReporteException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * <b> Controlador base </b>
 * 
 * @author Marcelo Hidalgo
 */
public class Base {

	private final String BUNDLE_NAME = "ec.com.bancoInternacional.config.applicationWeb";
	//private final String BUNDLE_MESSAGES = "ec.com.bancoInternacional.resources.messages_es_EC";

	private final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	//private final ResourceBundle RESOURCE_MESSAGES = ResourceBundle.getBundle(BUNDLE_MESSAGES);

	private static final Logger logger = Logger.getLogger(Base.class);

	
	private ServletContext contexto;
	private HttpSession session;
	
	/**
	 * Recupera el valor de la propiedad enviada
	 * 
	 * @param key
	 *            the key
	 * 
	 * @return the string
	 */
	public String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * Retorna la session http.
	 *
	 * @return session
	 */
	public HttpSession getSession() {		
		return this.session;
	}
	
	public void setSession(HttpSession session) {		
		this.session = session;
	}

	/**
	 * devuelve contexto.
	 *
	 * @return session
	 */
	protected void setExternalContext(ServletContext  contexto) {
		this.contexto = contexto;
	}
	
	protected ServletContext getExternalContext() {
		return getContexto();
	}

	public byte[] getReportePDF(String archivoJasper, Map<String, Object> parameters) throws GenerarReporteException {
		try {
			JasperPrint print = JasperFillManager.fillReport(new FileInputStream(getPath().concat(archivoJasper)),
					parameters);
			return JasperExportManager.exportReportToPdf(print);
		} catch (JRException | FileNotFoundException e) {
			logger.error("Ocurrio un error al generar el reporte..." + e.getMessage());
			throw new GenerarReporteException(e);
		}
	}

	public byte[] getReportePDF(String archivoJasper, Map<String, Object> parameters, JRDataSource data)
			throws GenerarReporteException {
		try {
			JasperPrint print = JasperFillManager.fillReport(new FileInputStream(getPath().concat(archivoJasper)),
					parameters, data);
			return JasperExportManager.exportReportToPdf(print);
		} catch (JRException | FileNotFoundException e) {
			logger.error("Ocurrio un error al generar el reporte..." + e.getMessage());
			throw new GenerarReporteException(e);
		}
	}

	public byte[] unionPdfs(List<PdfReader> reportes) throws DocumentException {
		Rectangle r = PageSize.A4;
		Document document = new Document(r);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		PdfContentByte cb = writer.getDirectContent();
		for (PdfReader pdfReader : reportes) {
			if(pdfReader != null){
				for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
					document.newPage();
					// import the page from source pdf
					PdfImportedPage page = writer.getImportedPage(pdfReader, i);
					float width = PageSize.A4.getWidth() / page.getWidth();
					float height = PageSize.A4.getHeight() / page.getHeight();
					// add the page to the destination pdf
					cb.addTemplate(page, width, 0, 0, height, 0, 0);
					// cb.addTemplate(page, 0, 0);
				}
			}
		}
		document.close();
		return outputStream.toByteArray();
	}

	public String getPath()
	{
		return ApplicationWeb.RUTA_REPORTES;
	}
	
	public String getRealPath() {
		String webContentRoot = this.getExternalContext().getRealPath("/");
		return webContentRoot;
	}
	
	public String getImageRealPath() {
		return this.getRealPath()+File.separator+"resources"+File.separator+"img"+File.separator;
	}
	
	/**
     * 
     * <b> Obtien al ip del cliente</b>
     * 
     * @return
     */
    protected String obtenerIpCliente() {
       
       String remoteAddr = "";
       HttpServletRequest request = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());            

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
       
    }

	public ServletContext getContexto() {
		return contexto;
	}

	public void setContexto(ServletContext contexto) {
		this.contexto = contexto;
	}
	
	/**
	 * Agrega una hoja en blanco en el pdf.
	 * 
	 * @return
	 */
	public static byte[] agregarHojaEnBlancoPdf() {
		Rectangle r = PageSize.A4;
		Document document = new Document(r);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter writer = null;
		byte[] arrayOutputStream = null;
		try {
			writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			writer.setPageEmpty(false);
			document.close();
			arrayOutputStream = outputStream.toByteArray();
		} catch (Exception e) {
			logger.error("Ocurrio error al agregar hoja en blanco en los reportes");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		return arrayOutputStream;
	} 
	
	/**
	 * Retorna el total de numero de hojas que contiene el pdf, se recibe
	 * como parametro la lista(pdfReader).
	 * 
	 * @param reportes
	 * @return
	 */
	public static int totalNumeroDeHojasPdf(List<PdfReader> reportes){
		int totalNumeroHojas = 0;
		int numeroDeHojasPorPdf = 0;
		for (PdfReader pdfReader : reportes) {
			if(pdfReader != null){
				numeroDeHojasPorPdf = pdfReader.getNumberOfPages();
				totalNumeroHojas = totalNumeroHojas + numeroDeHojasPorPdf; 
			}
		}
		return totalNumeroHojas;
	}
	
	
	/**
	 * Agrega una hoja en blanco al final en cualquier reporte pdf, 
	 * donde primero se valida que la hoja sea impar para agregarla.
	 */
	public void agregarHojaEnBlancoReportesPdf(List<PdfReader> reportes){
		PdfReader nuevaHojaEnBlanco = null;
		if(totalNumeroDeHojasPdf(reportes) %2 != 0){
			byte[] hojaEnBlanco = agregarHojaEnBlancoPdf();
			if(hojaEnBlanco != null){
				try {
					nuevaHojaEnBlanco = new PdfReader(hojaEnBlanco);
				} catch (IOException e) {
					logger.error("Ocurrio error al agregar la hoja en blanco en el pdf");
					logger.error(e.getMessage());
				}
				
				if(nuevaHojaEnBlanco != null){
					reportes.add(nuevaHojaEnBlanco);
				}
			}
		}
	}

}
