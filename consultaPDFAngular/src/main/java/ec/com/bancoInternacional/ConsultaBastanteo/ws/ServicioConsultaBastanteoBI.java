package ec.com.bancoInternacional.ConsultaBastanteo.ws;

import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import ec.com.bancoInternacional.ConsultaBastanteo.dataManager.CredencialesDM;
import ec.com.bancoInternacional.ConsultaBastanteo.dataManager.ReporteBastanteoHistoricoDM;
import ec.com.bancoInternacional.ConsultaBastanteo.excepcion.ClienteNoEncontradoException;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Cliente;
import ec.com.bancoInternacional.ConsultaBastanteo.service.ConsultaBastanteoFacade;
import ec.com.bancoInternacional.ConsultaBastanteo.singleton.CatalogosCache;
import ec.com.bancoInternacional.ConsultaBastanteo.util.ApplicationManager;
import ec.com.bancoInternacional.ConsultaBastanteo.util.Constantes;
import ec.com.bancoInternacional.ConsultaBastanteo.util.FormatoUtil;

@Stateless
@Path("/servicioConsulta/")
public class ServicioConsultaBastanteoBI {

	@EJB
	ConsultaBastanteoFacade servicio;
	
	@EJB
	CatalogosCache catalogosCache;
	
	private ReporteBastanteoHistoricoDM reporteDataManager = new ReporteBastanteoHistoricoDM();
	
	public ServicioConsultaBastanteoBI() {
		super();
	}

	@GET
	@Produces("application/json")
	@Path("/consulta")
	public Response getUltimoBastanteoPorIdentificacion(@Context HttpServletRequest request, @QueryParam("id") String id) {
		CredencialesDM credencialDataManager = new CredencialesDM();
		if (!credencialDataManager.validarCredenciales(request.getHeader(ApplicationManager.getString("app.header.usuario.nombre")), request.getHeader(ApplicationManager.getString("app.header.pass.nombre")))) {
			return Response.status(Response.Status.FORBIDDEN).entity(Constantes.NO_ATURIZACION_VIA_HEADER).build();
		}
		credencialDataManager = null;
		if (StringUtils.isBlank(id) || id.length() != 15) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("IDENTIFICACION INCORRECTA").build();
		}
		String identificacion = "";
		String tipoIdentificacion = id.substring(0, 1);
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
			return Response.status(Response.Status.NO_CONTENT).entity("NO SE HA ENCONTRADO CLIENTE").build();
		}
		try {
			Map<String, Object> parametrosReporte = reporteDataManager.obtenerParametrosReporte(catalogosCache,cliente);
			bytesAdevolver = reporteDataManager.obtenerPdf(catalogosCache,parametrosReporte, cliente);
			if (bytesAdevolver == null) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Interno").build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Interno").build();
		}
		String encoded = Base64.encodeBase64String(bytesAdevolver);
		return Response.ok().entity(encoded).build();
				
	}
}
