package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.objetoNego;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo.Titulo;

@Local
public interface ObjetoNegocioONLocal {
	public boolean guardarTitulo(String titulo, String cedula);
	public List<Titulo> listar(String palabra);

}
