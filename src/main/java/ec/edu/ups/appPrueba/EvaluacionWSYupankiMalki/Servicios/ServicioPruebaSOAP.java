package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Titulo;
import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.objetoNego.ObjetoNegocioONLocal;



@WebService
public class ServicioPruebaSOAP {
	@Inject
	private ObjetoNegocioONLocal on;
	
	@WebMethod
	public String registroTitulo(String titulo,String cedula) {
		boolean m = on.guardarTitulo(titulo, cedula);
		if (m) {
			return "OK";
		}
		return "ERROR";
	}
	
	
	@WebMethod
	public List<Titulo> listarTitulos(String palabra){
		List<Titulo> lista = on.listar(palabra);
		if (lista.size() > 0 ) {
			return lista;
		}/*else {
			return "No existen coicidencias";
		}*/
		return null;
	}
	

}
