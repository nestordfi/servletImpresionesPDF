package ec.com.bancoInternacional.ConsultaBastanteo.ws;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import ec.com.bancoInternacional.ConsultaBastanteo.modelo.Configuracion;
import ec.com.bancointernacional.seguridad.util.Util;
import ec.com.bancointernacional.seguridad.util.VariableDeAmbienteNoEncontradaException;

@Stateless
@Path("/public")
public class ConfiguracionServiceApi {
    private static final Logger LOG = Logger.getLogger(ConfiguracionServiceApi.class);
    
    @GET
    @Path("/configuracion")
    @Produces("application/json")
    public Response obtenerConfiguracion() {

        try {
            String loginUrl = Util.getEnvironmentValue("app.dir.login");
            String servletClientejuridicoGwt = Util.getEnvironmentValue("servlet.clientejuridico.gwt");
            String cuentasUrl = Util.getEnvironmentValue("clientes.cuentas");
            String clientesNaturalesUrl = Util.getEnvironmentValue("clientes.natural");
            String informacionTributariaBeneficiarioFinalUrl = Util.getEnvironmentValue("informacion.tributaria.beneficiario.final");
            String checklistUrl = Util.getEnvironmentValue("checklist");
            Integer sessionTimeOutMinutes = Util.getEnvironmentValue("sessionTimeOutMinutes");
            Configuracion config = new Configuracion();
            config.setLoginUrl(loginUrl);
            config.setServletClienteJuridicoGwt(servletClientejuridicoGwt);
            config.setCuentasUrl(cuentasUrl);
            config.setClientesNaturalesUrl(clientesNaturalesUrl);
            config.setInformacionTributariaBeneficiarioFinalUrl(informacionTributariaBeneficiarioFinalUrl);
            config.setChecklistUrl(checklistUrl);
            config.setSessionTimeOutMinutes(sessionTimeOutMinutes);
            
            return Response.ok().entity(config).build();
        } catch (VariableDeAmbienteNoEncontradaException e) {
            LOG.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }   

    }

}