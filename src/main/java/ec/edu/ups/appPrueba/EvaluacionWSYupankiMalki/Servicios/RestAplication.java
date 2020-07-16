package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Servicios;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition( servers = {
		   @Server(description = "Servidor Local",
				   url = "/EvaluacionWSYupankiMalki")		
			}		
)
@ApplicationPath("/rs")
public class RestAplication extends Application {

}
