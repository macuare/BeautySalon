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
public class Tokens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idToken;
	@NotNull
	private String tokenFirebase;
	@NotNull
	private String tokenSpring;
	
	@OneToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "tokenUsuario")
	private Usuarios usuarios;
	
	public int getIdToken() {
		return idToken;
	}
	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}
	
	public String getTokenFirebase() {
		return tokenFirebase;
	}
	public void setTokenFirebase(String tokenFirebase) {
		this.tokenFirebase = tokenFirebase;
	}
	public String getTokenSpring() {
		return tokenSpring;
	}
	public void setTokenSpring(String tokenSpring) {
		this.tokenSpring = tokenSpring;
	}
	
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	@Override
	public String toString() {
		return "Tokens [idToken=" + idToken + ", tokenFirebase=" + tokenFirebase
				+ ", tokenSpring=" + tokenSpring + "]";
	}
	
	
	
}
