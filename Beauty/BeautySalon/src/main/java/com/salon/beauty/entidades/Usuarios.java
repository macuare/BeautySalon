package com.salon.beauty.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuarios {

	@Id	
	private String tokenUsuario;
	//@NotNull
	private String usuario;
	//@NotNull
	private String correo;
	//@NotNull
	private String telefono;
	//@NotNull 
	private Long fecha;
	
	@OneToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
	@JsonBackReference(value = "pines-usuario")
	private Set<Pines> pines;
	
	@OneToOne(mappedBy = "usuarios", fetch = FetchType.EAGER)
	@JsonBackReference(value = "seguridad-usuarios")
	private Seguridad seguridad;
	
	@OneToOne(mappedBy = "usuarios", fetch = FetchType.EAGER)
	@JsonBackReference(value = "tokens-usuarios")
	private Tokens tokens;
	
	@OneToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)	
	@JsonBackReference(value = "contratacion-usuario")
	private Set<Contratacion> contratacion;
	
	@OneToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)	
	@JsonBackReference(value = "servicios-usuario")
	private Set<Servicios> servicios;
	
	
	public String getTokenUsuario() {
		return tokenUsuario;
	}
	public void setTokenUsuario(String tokenUsuario) {
		this.tokenUsuario = tokenUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Usuarios [tokenUsuario=" + tokenUsuario + ", usuario=" + usuario + ", correo=" + correo + ", telefono="
				+ telefono + ", fecha=" + fecha + ", pines=" + pines + "]";
	}
	
	public Seguridad getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(Seguridad seguridad) {
		this.seguridad = seguridad;
	}
	public Tokens getTokens() {
		return tokens;
	}
	public void setTokens(Tokens tokens) {
		this.tokens = tokens;
	}
	public Set<Pines> getPines() {
		return pines;
	}
	public void setPines(Set<Pines> pines) {
		this.pines = pines;
	}
	public Set<Contratacion> getContratacion() {
		return contratacion;
	}
	public void setContratacion(Set<Contratacion> contratacion) {
		this.contratacion = contratacion;
	}
	
	
	
	
	
	
}
