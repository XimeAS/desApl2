package xas.model;

import java.io.Serializable;

public class PromEdu implements Serializable {

	private Long id;
	private int numeroalumnos;
	private String carrera;
	private String edificio;
	
	public PromEdu(Long id, int numeroalumnos, String carrera, String edificio) {
		super();
		this.id = id;
		this.numeroalumnos = numeroalumnos;
		this.carrera = carrera;
		this.edificio = edificio;
	}

	public PromEdu() {
		this(0L,0,"","");
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroalumnos() {
		return numeroalumnos;
	}

	public void setNumeroalumnos(int numeroalumnos) {
		this.numeroalumnos = numeroalumnos;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "PromEdu [id=" + id + ", numeroalumnos=" + numeroalumnos + ", carrera=" + carrera + ", edificio="
				+ edificio + "]";
	}
}
