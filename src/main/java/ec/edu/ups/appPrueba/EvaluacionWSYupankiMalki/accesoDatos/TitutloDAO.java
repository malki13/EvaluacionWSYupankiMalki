package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.accesoDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Titulo;


@Stateless
public class TitutloDAO {
	
	@PersistenceContext(name = "EvaluacionWSYupankiMalkiPersistenceUnit")
	private EntityManager em;
	
	
	public void insert(Titulo s) {
		em.persist(s);
	}
	
	
	public void update(Titulo s) {
		em.merge(s);
	}
	
	
	public Titulo read(int codigoTransaccion) {
		return em.find(Titulo.class, codigoTransaccion);
	}
	
	
	
	public void delete(int codT) {
		Titulo c = read(codT);
		em.remove(c);
	}
	
	
	public List<Titulo> getListaTransacciones(String cedula) throws Exception {
		try {
			String jpql = "SELECT s FROM Titulo s Where s.cedula.cedula =:ced";
			Query q = em.createQuery(jpql, Titulo.class);
			q.setParameter("ced", cedula);
			return q.getResultList();
		} catch (NoResultException e) {
			// System.out.println(e.getMessage());
			throw new Exception("Credenciaales Inocorrectas");
		}

	}
	
	
	public List<Titulo> getListaTitulos(String palabra) throws Exception {
		try {
			String jpql = "SELECT s FROM Titulo s Where s.titulo like '%"+palabra+"%'";
			Query q = em.createQuery(jpql, Titulo.class);
			return q.getResultList();
		} catch (NoResultException e) {
			// System.out.println(e.getMessage());
			throw new Exception("Credenciaales Inocorrectas");
		}
	}
	
	

}
