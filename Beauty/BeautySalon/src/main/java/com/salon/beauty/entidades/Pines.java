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
public class Pines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPin;
	
	//@NotNull
	private String pin;
	//@NotNull
	private String telefono;
	//@NotNull
	private Long fecha;
	
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "tokenUsuario")
	private Usuarios usuarios;
	
	
	public int getIdPin() {
		return idPin;
	}
	public void setIdPin(int idPin) {
		this.idPin = idPin;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
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
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public String toString() {
		return "Pines [idPin=" + idPin + ", pin=" + pin + ", telefono=" + telefono
				+ ", fecha=" + fecha + "]";
	}
	
	

}
