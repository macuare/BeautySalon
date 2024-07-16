package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Seguridad;
import com.salon.beauty.repositorios.SeguridadRepository;

@Service
public class SeguridadServiceImpl implements SeguridadService {
	
	@Autowired
	private SeguridadRepository sr;

	@Override
	public List<Seguridad> listarSeguridad() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Seguridad buscarPorId(int idSeguridad) {
		// TODO Auto-generated method stub
		return sr.getOne(idSeguridad);
	}

	
	@Override
	public Seguridad agregarNuevo(Seguridad seguridad) {
		// TODO Auto-generated method stub
		return sr.save(seguridad);
	}

	@Override
	public void actualizarSeguridad(Seguridad seguridad) {
		// TODO Auto-generated method stub
		sr.save(seguridad);
	}

	@Override
	public void borrarSeguridadPorId(int idSeguridad) {
		// TODO Auto-generated method stub
		sr.delete(idSeguridad);
		
	}

	
}
