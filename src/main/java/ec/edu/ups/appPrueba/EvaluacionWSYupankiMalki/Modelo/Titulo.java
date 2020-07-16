package ec.edu.ups.appPrueba.EvaluacionWSYupankiMalki.Modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Titulo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String titulo;
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "cedula")
	private Persona cedula;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getCedula() {
		return cedula;
	}

	public void setCedula(Persona cedula) {
		this.cedula = cedula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Titulo [codigo=" + codigo + ", titulo=" + titulo + ", estado=" + estado + ", cedula=" + cedula + "]";
	}
	
	
	
	
	

}
