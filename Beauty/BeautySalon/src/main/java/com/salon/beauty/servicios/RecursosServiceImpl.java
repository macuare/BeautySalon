package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Recursos;
import com.salon.beauty.repositorios.RecursosRepository;

@Service
public class RecursosServiceImpl implements RecursosService {

	@Autowired
	private RecursosRepository rr;
	
	@Override
	public List<Recursos> listarRecursos() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public Recursos buscarPorId(int idRecurso) {
		// TODO Auto-generated method stub
		return rr.findOne(idRecurso);
	}

	@Override
	public Recursos agregarNuevoRecurso(Recursos recurso) {
		// TODO Auto-generated method stub
		return rr.save(recurso);
	}

	@Override
	public void actualizarRecurso(Recursos recurso) {
		// TODO Auto-generated method stub
		rr.saveAndFlush(recurso);

	}

	@Override
	public void borrarRecursoPorId(int idRecurso) {
		// TODO Auto-generated method stub
		rr.delete(idRecurso);
	}

	@Override
	public List<Recursos> buscarRecursosPorIdServicio(int idServicio) {
		// TODO Auto-generated method stub
		return rr.findResourceByService(idServicio);
	}

}
