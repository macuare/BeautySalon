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
public class Recursos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecurso;
	@NotNull
	private String url;
	@NotNull
	private Long fecha;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "clasificacion_Id")
	private Clasificacion clasificaciones;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "idServicio")
	private Servicios servicios;
	
	
	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getFecha() {
		return fecha;
	}

	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}

	public Clasificacion getClasificaciones() {
		return clasificaciones;
	}

	public void setClasificaciones(Clasificacion clasificaciones) {
		this.clasificaciones = clasificaciones;
	}

	

	public Servicios getServicios() {
		return servicios;
	}

	public void setServicios(Servicios servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Recursos [idRecurso=" + idRecurso + ", url=" + url + ", fecha=" + fecha + ", clasificaciones="
				+ clasificaciones.getIdClasificacion() + ", servicios=" + servicios.getIdServicio() + "]";
	}
	
	
	

}
