package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.objetoNego;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Persona;
import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Titulo;
import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.accesoDatos.PersonaDAO;
import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.accesoDatos.TitutloDAO;

@Stateless
public class ObjetoNegocioON implements ObjetoNegocioONLocal{
	
	
	@Inject
	TitutloDAO titutloDAO;
	@Inject
	PersonaDAO personaDAO;
	
	
	public boolean guardarTitulo(String titulo, String cedula){
		Titulo t = new Titulo();
		
		t.setEstado("INGRESADO");
		t.setTitulo(titulo);
		Persona p = personaDAO.obtenerbuscar2(cedula);
		t.setCedula(p);
		
		titutloDAO.insert(t);
		return true;
		
    }
	
	public List<Titulo> listar(String palabra){
		try {
			List<Titulo> lista = titutloDAO.getListaTitulos(palabra);
			return lista;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
