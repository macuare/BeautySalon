package com.salon.beauty.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seguridad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSeguridad;
	
	@NotNull
	private String clave;
	
	@OneToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "tokenUsuario")
	private Usuarios usuarios;
	
	public int getIdSeguridad() {
		return idSeguridad;
	}
	public void setIdSeguridad(int idSeguridad) {
		this.idSeguridad = idSeguridad;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "Seguridad [idSeguridad=" + idSeguridad + ", clave=" + clave + ", usuarios=" + usuarios + "]";
	}

	
	
	
	

}
