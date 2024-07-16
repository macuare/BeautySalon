package com.salon.beauty.entidades;

import java.util.Set;

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
public class Clientes {
	@Id	
	private String idCliente;
	@NotNull
	private String nombres;
	@NotNull
	private String apellidos;
	@NotNull
	private String correo;
	@NotNull
	private String telefono;
	@NotNull
	private Long fechaRegistro;
	
	@OneToMany(mappedBy = "clientes", fetch = FetchType.EAGER)	
	@JsonBackReference(value = "servicios-clientes")
	private Set<Servicios> servicios;
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	public Long getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Long fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo="
				+ correo + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + "]";
	}
	public Set<Servicios> getServicios() {
		return servicios;
	}
	public void setServicios(Set<Servicios> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
}
