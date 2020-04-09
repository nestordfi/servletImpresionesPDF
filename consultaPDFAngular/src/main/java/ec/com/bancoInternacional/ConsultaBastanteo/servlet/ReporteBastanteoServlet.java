package ec.com.bancoInternacional.ConsultaBastanteo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import ec.com.bancoInternacional.ConsultaBastanteo.dataManager.ReporteBastanteoHistoricoDM;
import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.ClienteNoEncontradoException;
import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.PooledTrxException;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cliente;
import ec.com.bancoInternacional.ConsultaBastanteo.service.ConsultaBastanteoFacade;
import ec.com.bancoInternacional.ConsultaBastanteo.singleton.CatalogosCache;
import ec.com.bancoInternacional.ConsultaBastanteo.util.Constantes;
import ec.com.bancoInternacional.ConsultaBastanteo.util.FormatoUtil;
import ec.com.bancoInternacional.ConsultaBastanteo.util.GeneralUtil;
import ec.com.bancoInternacional.server.seguridad.Credencial;

/**
 * Servlet implementation class ReporteActualizacion
 */
@WebServlet("/servlet/reporteBastanteo")
public class ReporteBastanteoServlet extends HttpServlet {
	
	@EJB
	ConsultaBastanteoFacade servicio;
	
	@EJB
	CatalogosCache catalogosCache;
	
//	private static final Logger logger = Logger.getLogger(ReporteBastanteoServlet.class);
	
	private ReporteBastanteoHistoricoDM reporteDataManager = new ReporteBastanteoHistoricoDM();
	
    private static final long serialVersionUID = 1L;

    public ReporteBastanteoServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    	String user = request.getParameter("usuario");
    	try {
	    	if (user == null) {
	    		String mensaje = String.format("<br/>No se encontró session valida con el usuario indicado");
				pantallaError(response, mensaje);
				return;
			}
			String usuario = GeneralUtil.desencriptarString(user);
			Credencial credencial = new Credencial();
			try {
				credencial = this.CargarCredenciales(servicio, usuario, request.getSession());
			} catch (PooledTrxException e) {
				e.printStackTrace();
			}
			
			if (credencial == null) {
				String mensaje = String.format("<br/>No se encontró session valida con el usuario indicado");
				pantallaError(response, mensaje);
				return;
			}
		
    		String id = request.getParameter("id");
    		if (StringUtils.isBlank(id)) {
    			String mensaje = String.format("<br/>No se encontró una identificación válida");
				pantallaError(response, mensaje);
				return;
			}
	    	String tipoIdentificacion = id.substring(0, 1);
	    	String identificacion = "";
	    	if (Constantes.PASAPORTE_TIPO_ID.equals(tipoIdentificacion)) {
	    		identificacion = FormatoUtil.eliminarCerosDeLaIzquierdaEnPasaporte(id.substring(1,id.length()));
	    	}else{
	    		identificacion = id.substring(1, id.length()-1);
	    	}
			byte[] bytesAdevolver = null;
			Cliente cliente = new Cliente();
			try {
				cliente = servicio.consultaBastanteoPorIdentificacion(identificacion,tipoIdentificacion);
			} catch (ClienteNoEncontradoException e1) {
				String mensaje = String.format("<br/>No se encontraron datos para la identificacion indicada: " + id);
				pantallaError(response, mensaje);
				return;
			}
			try {
				Map<String, Object> parametrosReporte = reporteDataManager.obtenerParametrosReporte(catalogosCache,cliente);
				bytesAdevolver = reporteDataManager.obtenerPdf(catalogosCache,parametrosReporte, cliente);
				if (bytesAdevolver == null) {
					pantallaError(response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
				pantallaError(response);
				return;
			}
			this.processReport(response,bytesAdevolver);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    public Credencial CargarCredenciales(ConsultaBastanteoFacade servicio, String usuarioDesencriptado, HttpSession session) throws PooledTrxException{
		Date fechaActual = new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MMM-dd");
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
		Credencial credencial = new Credencial(usuarioDesencriptado, session, formatofecha.format(fechaActual),
				formatoHora.format(fechaActual), fechaActual.getTime());
		return servicio.getCntrlBth(credencial);
	}
    
    private void pantallaError(HttpServletResponse response, String mensaje) throws IOException {
		response.setContentType("text/html");
		response.getWriter().print(
				"<!DOCTYPE html>"
				+ "	<html>"
				+ "		<body>"
				+ "	El reporte no se pudo generar, comuníquese con TI."
				+"<br/>"
				+mensaje
				+"<br/>"
				+ "		</body>"
				+ "</html>");
	}

	private void pantallaError(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.getWriter().print(
				"<!DOCTYPE html><html><body>El reporte no se pudo generar, comuníquese con TI.</body></html>");
	}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void processReport(final HttpServletResponse response, final byte[] bytes) throws IOException {
		final ServletOutputStream servletOutputStream = response.getOutputStream();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		servletOutputStream.write(bytes, 0, bytes.length);
		servletOutputStream.flush();
		servletOutputStream.close();
	}

}
