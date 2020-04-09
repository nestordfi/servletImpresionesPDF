package ec.com.bancoInternacional.ConsultaBastanteo.ws;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ObjCliente;
import ec.com.bancoInternacional.ConsultaBastanteo.modelo.ParametroBuscarCliente;
import ec.com.bancoInternacional.ConsultaBastanteo.service.ConsultaBastanteoFacade;

@Stateless
@Path("/private/juridico")
public class JuridicoWebService {
	private static final Logger LOG = Logger.getLogger(JuridicoWebService.class);
	
	@EJB
	ConsultaBastanteoFacade servicio;

	@GET
	@Produces("application/json")
	@Path("/busqueda")
	public Response busquedaClientes (@QueryParam("nombreCorto") String nombreCorto,
			@QueryParam("nroIbs") BigDecimal nroIbs, @QueryParam("id") String id,
			@QueryParam("grupoMaster") String grupoMaster){
		ParametroBuscarCliente parametroBuscarCliente = new ParametroBuscarCliente(nombreCorto, nroIbs, id, grupoMaster);
		List<ObjCliente> listaClientesEncontrados;
		try {
			listaClientesEncontrados = servicio.buscaClientePorNombre(parametroBuscarCliente);
			return Response.ok().entity(listaClientesEncontrados).build();
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Interno").build();
		} catch (ExecutionException e) {
			LOG.error(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Interno").build();			
		}
	}
}