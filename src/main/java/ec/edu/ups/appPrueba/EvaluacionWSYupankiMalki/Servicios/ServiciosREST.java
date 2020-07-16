package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Titulo;
import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.objetoNego.ObjetoNegocioONLocal;


@Path("/servicioPrueba")
public class ServiciosREST {
	
	@Inject
	ObjetoNegocioONLocal on;
	
	@GET
	@Path("/listado/{palabra}")
	@Produces("application/json")
	public List<Titulo> listar(@PathParam("palabra") String palabra) {
		List<Titulo> lista = on.listar(palabra);
		if (lista.size() > 0 ) {
			return lista;
		}/*else {
			return "No existen coicidencias";
		}*/
		return null;
	}
	
	
	@POST
	@Path("/IngreTit")
	@Produces("application/json")
	@Consumes("application/json")
	public String listarREST(Titulo t) {
		boolean by = on.guardarTitulo(t.getTitulo(), t.getCedula().getCedula());
		if (by) {
			return "Ingresado REST";
		}
		return "Error REST";
	}

}
