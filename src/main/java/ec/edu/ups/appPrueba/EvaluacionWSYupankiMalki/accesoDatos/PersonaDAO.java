package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.accesoDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Persona;


@Stateless
public class PersonaDAO {
	@PersistenceContext(name = "EvaluacionWSYupankiMalkiPersistenceUnit") 
	private EntityManager con;
	
	public boolean insertarPersona(Persona persona) {
		con.persist(persona);
		return true;
	}
	
	
	public Persona obtenerbuscar2(String nombre) {
		 return con.find(Persona.class, nombre);
	}
	
	public Persona obtene2(String nom) {
		String jpql = "SELECT t FROM Persona t " 
				+ "WHERE t.nombre =:nombre";
		Query q = con.createQuery(jpql, Persona.class);
		q.setParameter("nombre", nom);
		return (Persona) q.getSingleResult();
		
	}
	
	public boolean editar_modelo(Persona pers) {
		con.merge(pers);
		return true;
	}
	
	public List<Persona> obtener() {
		String jpl = "select p from Persona p";
		Query q = con.createQuery(jpl, Persona.class);
		//Query q = con.createNativeQuery(jpl, Persona.class) ;
		return q.getResultList();
	
	}
	
	public void eliminarpersona(Persona per) {
		Persona p = obtenerbuscar2(per.getCedula());
		con.remove(p);

    }

}
