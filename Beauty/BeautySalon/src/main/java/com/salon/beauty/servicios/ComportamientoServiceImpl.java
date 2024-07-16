package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Comportamiento;
import com.salon.beauty.repositorios.ComportamientoRepository;

@Service
public class ComportamientoServiceImpl implements ComportamientoService {

	@Autowired
	private ComportamientoRepository cr;
	
	@Override
	public List<Comportamiento> listarComportamientos() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

}
