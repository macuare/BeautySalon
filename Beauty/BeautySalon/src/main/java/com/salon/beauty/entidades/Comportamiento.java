package com.salon.beauty.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comportamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComportamiento;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "comportamiento", fetch=FetchType.EAGER)//, fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Estudiante> estudiante;
	
	
	public int getIdComportamiento() {
		return idComportamiento;
	}
	public void setIdComportamiento(int idComportamiento) {
		this.idComportamiento = idComportamiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Estudiante> getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(List<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "Comportamiento [idComportamiento=" + idComportamiento + ", descripcion=" + descripcion + ", estudiante="
				+ estudiante + "]";
	}
	
	
	

}
