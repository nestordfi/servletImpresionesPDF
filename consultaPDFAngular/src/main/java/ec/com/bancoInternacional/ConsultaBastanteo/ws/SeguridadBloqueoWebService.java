package ec.com.bancoInternacional.ConsultaBastanteo.ws;


import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.ConsultaBastanteo.modelo.CredencialLight;
import ec.com.bancoInternacional.ConsultaBastanteo.util.SeguridadUtil;
import ec.com.bancointernacional.seguridad.bean.Credencial;
import ec.com.bancointernacional.seguridad.manager.SecurityManager;

@Stateless
@Path("/private/seguridad")
public class SeguridadBloqueoWebService {
	private static final Logger LOG = Logger.getLogger(SeguridadBloqueoWebService.class);
	
    @GET
    @Path("/credencial")
    @Produces("application/json")
    public Response obtenerCredencial(@Context HttpServletRequest request) {

        String codigoAcceso = (String) request.getSession().getAttribute("codigoAcceso");
        Credencial c;
        
        try {
        	System.out.println("Codigo de acceso: " + codigoAcceso);
        	c = SecurityManager.recuperarCredencial(codigoAcceso);

            LOG.debug("Credencial recuperada: " + request.getSession().getId());
            
            CredencialLight cl = new CredencialLight(c.getBthUbr(), c.getBthNom(), c.getUsuario(), c.getFecha(), c.getHora(),
            		SeguridadUtil.encriptar(c.getUsuario()), c.isSeguridadIBS());
            return Response.ok().entity(cl).build();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            String format = String.format("No se pudo cargar credenciales");
            return Response.status(Response.Status.NOT_FOUND).entity(format).build();
        }
    }
    
    @GET
    @Path("/cifrar")
    @Produces("application/json")
    public Response cifrar(@QueryParam("texto") String texto) {
        try {
        	return Response.ok().entity("[{\"textoCifrado\": \""+SeguridadUtil.encriptar(texto)+"\"}]").build();
        } catch (Exception e) {
        	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Interno").build();
        }
    }
}