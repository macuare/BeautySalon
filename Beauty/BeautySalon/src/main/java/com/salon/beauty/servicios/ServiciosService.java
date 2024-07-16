package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Servicios;

public interface ServiciosService {
	
	public List<Servicios> listarServicios();
	public Servicios buscarPorId(int idServicio);
	public Servicios buscarPorFecha(long fecha);
	public Servicios agregarNuevoServicio(Servicios servicio);
	public void actualizarServicio(Servicios servicio);
	public void borrarServicioPorId(int idServicio);

}
