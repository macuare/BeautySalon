package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Clasificacion;

public interface ClasificacionService {
	
	public List<Clasificacion> listarClasificaciones();
	public Clasificacion buscarPorId(int idClasificacion);
	public Clasificacion agregarNuevaClasificacion(Clasificacion clasificacion);
	public void actualizarClasificacion(Clasificacion clasificacion);
	public void borrarClasificacionPorId(int idClasificacion);

}
