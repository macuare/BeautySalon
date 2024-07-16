package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Estudiante;
import com.salon.beauty.entidades.Locales;


public interface EstudianteService {
	
	public List<Estudiante> listarEstudiantes();
	
	public Estudiante buscarPorId(int idEstudiante);	
	public Estudiante agregarNuevoEstudiante(Estudiante estudiante);
	public void actualizarEstudiante(Estudiante estudiante);
	public void borrarEstudiantePorId(int idEstudiante);

}
