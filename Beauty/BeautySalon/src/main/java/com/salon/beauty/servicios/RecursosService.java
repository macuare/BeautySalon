package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Recursos;

public interface RecursosService {
	
	public List<Recursos> listarRecursos();
	public Recursos buscarPorId(int idRecurso);
	public List<Recursos> buscarRecursosPorIdServicio(int idServicio);
	public Recursos agregarNuevoRecurso(Recursos recurso);
	public void actualizarRecurso(Recursos recurso);
	public void borrarRecursoPorId(int idRecurso);
	

}
