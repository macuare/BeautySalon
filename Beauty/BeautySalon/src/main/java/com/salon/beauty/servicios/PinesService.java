package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Pines;


public interface PinesService {
	
	public List<Pines> listarLosPines();
	public Pines buscarPorId(int idPin);
	public Pines agregarNuevoPin(Pines pin);
	public void actualizarPin(Pines pin);
	public void borrarPinPorId(int idPin);
	

}
