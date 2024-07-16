package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Contratacion;

public interface ContratacionService {
	
	public List<Contratacion> listarLosContratos();
	public Contratacion buscarPorId(int idContrato);
	public Contratacion agregarNuevoContrato(Contratacion contratacion);
	public void actualizarContrato(Contratacion contratacion);
	public void borrarContratoPorId(int idContrato);

}
