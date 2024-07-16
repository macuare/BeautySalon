package com.salon.beauty.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstudiante;
	private String nombres;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "estado")
	//@JsonManagedReference //es el que posiblemente da problema para insertar, actualizar y eliminar
	private Comportamiento comportamiento;

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}

	public void setComportamiento(Comportamiento comportamiento) {
		this.comportamiento = comportamiento;
	}

	@Override
	public String toString() {
		return "Estudiante [idEstudiante=" + idEstudiante + ", nombres=" + nombres + ", comportamiento="
				+ comportamiento + "]";
	}
	
	

}
