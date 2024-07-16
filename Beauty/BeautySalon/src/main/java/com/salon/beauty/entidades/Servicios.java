package com.salon.beauty.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Servicios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	@NotNull
	private Long fecha;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "tokenUsuario")
	private Usuarios usuarios;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idCliente")
	private Clientes clientes;
	
	@OneToMany(mappedBy = "servicios", fetch = FetchType.EAGER)	
	@JsonBackReference(value = "recursos-servicios")
	private Set<Recursos> recursos;
	
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	
	public Long getFecha() {
		return fecha;
	}
	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return "Servicios [idServicio=" + idServicio + ", fecha=" + fecha + ", usuarios=" + usuarios.getTokenUsuario() + ", clientes="
				+ clientes.getIdCliente() + ", recursos=" + recursos.toArray() + "]";
	}
	public Set<Recursos> getRecursos() {
		return recursos;
	}
	public void setRecursos(Set<Recursos> recursos) {
		this.recursos = recursos;
	}
	
	
	
	
	
	
}
