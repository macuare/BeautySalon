package com.salon.beauty.modelos.beans;

public class DescripcionSubidaArchivo {
	
	 private String NombreArchivo;
	 private String ruta;
	 private String tipoArchivo;
	 private long peso;
	 
	 
	public DescripcionSubidaArchivo(String nombreArchivo, String ruta, String tipoArchivo, long peso) {
		super();
		NombreArchivo = nombreArchivo;
		this.ruta = ruta;
		this.tipoArchivo = tipoArchivo;
		this.peso = peso;
	}
	
	
	public String getNombreArchivo() {
		return NombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		NombreArchivo = nombreArchivo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getTipoArchivo() {
		return tipoArchivo;
	}
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}
	public long getPeso() {
		return peso;
	}
	public void setPeso(long peso) {
		this.peso = peso;
	}
	 
	 
	 

}
