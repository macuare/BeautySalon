package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Pines;
import com.salon.beauty.repositorios.PinesRepository;

@Service
public class PinesServiceImpl implements PinesService{

	@Autowired
	private PinesRepository pinesRepository;
	
	@Override
	public List<Pines> listarLosPines() {
		// TODO Auto-generated method stub
		return pinesRepository.findAll();
	}

	@Override
	public Pines buscarPorId(int idPin) {
		// TODO Auto-generated method stub
		return pinesRepository.findOne(idPin);
	}

	
	@Override
	public Pines agregarNuevoPin(Pines pin) {
		// TODO Auto-generated method stub
		return pinesRepository.save(pin);
	}

	@Override
	public void actualizarPin(Pines pin) {
		// TODO Auto-generated method stub
		pinesRepository.save(pin);
	}

	@Override
	public void borrarPinPorId(int idPin) {
		// TODO Auto-generated method stub
		pinesRepository.delete(idPin);
	}

	
	
	
}
