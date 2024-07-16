package com.salon.beauty.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contratacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContrato;
	@NotNull
	private boolean status;
	@NotNull
	private Long fecha;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "tokenUsuario")
	private Usuarios usuarios;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idLocal")
	private Locales locales;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idRol")
	private Roles roles;
	
	
	
	public int getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Contratacion [idContrato=" + idContrato + ", status=" + status + ", fecha=" + fecha + ", usuarios="
				+ usuarios + "]";
	}
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	public Locales getLocales() {
		return locales;
	}
	public void setLocales(Locales locales) {
		this.locales = locales;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
	
	
}
