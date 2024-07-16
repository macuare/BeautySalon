package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Servicios;
import com.salon.beauty.repositorios.ServiciosRepository;

@Service
public class ServiciosServiceImpl implements ServiciosService {
	
	@Autowired
	private ServiciosRepository sr;

	@Override
	public List<Servicios> listarServicios() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Servicios buscarPorId(int idServicio) {
		// TODO Auto-generated method stub
		return sr.findOne(idServicio);
	}

	

	@Override
	public Servicios buscarPorFecha(long fecha) {
		// TODO Auto-generated method stub
		Servicios servicio = new Servicios();
		servicio.setFecha(fecha);
		
		Example<Servicios> example = Example.of(servicio);
		
		return sr.findOne(example);
	}

	@Override
	public Servicios agregarNuevoServicio(Servicios servicio) {
		// TODO Auto-generated method stub
		return sr.save(servicio);
	}

	@Override
	public void actualizarServicio(Servicios servicio) {
		// TODO Auto-generated method stub
		sr.saveAndFlush(servicio);
	}

	@Override
	public void borrarServicioPorId(int idServicio) {
		// TODO Auto-generated method stub
		sr.delete(idServicio);
	}

}
