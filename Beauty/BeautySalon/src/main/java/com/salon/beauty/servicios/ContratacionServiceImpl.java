package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Contratacion;
import com.salon.beauty.repositorios.ContratacionRepository;

@Service
public class ContratacionServiceImpl implements ContratacionService {
	
	@Autowired
	private ContratacionRepository cr;

	@Override
	public List<Contratacion> listarLosContratos() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Contratacion buscarPorId(int idContrato) {
		// TODO Auto-generated method stub
		return cr.findOne(idContrato);
	}

	@Override
	public Contratacion agregarNuevoContrato(Contratacion contratacion) {
		// TODO Auto-generated method stub
		return cr.save(contratacion);
	}

	@Override
	public void actualizarContrato(Contratacion contratacion) {
		// TODO Auto-generated method stub
		cr.save(contratacion);
	}

	@Override
	public void borrarContratoPorId(int idContrato) {
		// TODO Auto-generated method stub
		cr.delete(idContrato);

	}

}
