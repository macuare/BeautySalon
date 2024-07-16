package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Seguridad;



public interface SeguridadService {
	
	public List<Seguridad> listarSeguridad();
	public Seguridad buscarPorId(int idSeguridad);
	public Seguridad agregarNuevo(Seguridad seguridad);
	public void actualizarSeguridad(Seguridad seguridad);
	public void borrarSeguridadPorId(int idSeguridad);

}
