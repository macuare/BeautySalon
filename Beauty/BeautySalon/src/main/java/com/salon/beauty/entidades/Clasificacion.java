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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clasificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClasificacion;
	@NotNull
	private String tipo;
	 
	@OneToMany(mappedBy = "clasificaciones", fetch = FetchType.EAGER)
	@JsonBackReference(value = "recursos-clasificacion")
	private Set<Recursos> recursos;
	
	
	
	public int getIdClasificacion() {
		return idClasificacion;
	}
	public void setIdClasificacion(int idClasificacion) {
		this.idClasificacion = idClasificacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Clasificacion [idClasificacion=" + idClasificacion + ", tipo=" + tipo + "]";
	}
	public Set<Recursos> getRecursos() {
		return recursos;
	}
	public void setRecursos(Set<Recursos> recursos) {
		this.recursos = recursos;
	}
	
	

}
