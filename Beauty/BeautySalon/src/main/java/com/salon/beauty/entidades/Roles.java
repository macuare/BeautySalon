package com.salon.beauty.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
	@NotNull
	private String tipo;
	
	@OneToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	@JsonBackReference(value = "contratacion-roles")
	private List<Contratacion> contrataciones;
	
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Roles [idRol=" + idRol + ", tipo=" + tipo + "]";
	}
	public List<Contratacion> getContrataciones() {
		return contrataciones;
	}
	public void setContrataciones(List<Contratacion> contrataciones) {
		this.contrataciones = contrataciones;
	}
	
	
	

}
