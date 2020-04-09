package ec.com.bancoInternacional.ConsultaBastanteo.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;

@Stateless
@Path("/servicioPersonas/")
@Produces("application/json")
public class ServicioPersonasPrueba {

	private static List<Persona> listaPersonas = new ArrayList<Persona>();

	public ServicioPersonasPrueba() {
		super();
		Persona yo = new Persona("pedro", "perez");
		listaPersonas.add(yo);
	}

	@GET
	@Path("/personas")
	public List<Persona> getPersonas() {

		return listaPersonas;
	}

	@POST
	@Path("/personas")
	public void addPersona(MultivaluedMap<String, String> parametros) {

		Persona p = new Persona(parametros.getFirst("nombre"), parametros.getFirst("apellidos"));
		listaPersonas.add(p);
	}

}

