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
public class Locales {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLocal;
	@NotNull
	private String empresa;
	@NotNull
	private String direccion;
	
	@OneToMany(mappedBy = "locales", fetch = FetchType.EAGER)
	@JsonBackReference(value = "contratacion-locales")
	private List<Contratacion> contrataciones;
	
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Locales [idLocal=" + idLocal + ", empresa=" + empresa + ", direccion=" + direccion + "]";
	}
	public List<Contratacion> getContrataciones() {
		return contrataciones;
	}
	public void setContrataciones(List<Contratacion> contrataciones) {
		this.contrataciones = contrataciones;
	}
	
	
}
