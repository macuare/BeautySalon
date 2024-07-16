package com.salon.beauty.servicios;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Estudiante;
import com.salon.beauty.repositorios.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	private static final Logger log = Logger.getLogger(EstudianteServiceImpl.class);
	
	@Autowired
	private EstudianteRepository er;

	@Override
	public List<Estudiante> listarEstudiantes() {
		// TODO Auto-generated method stub
		List<Estudiante> elementos = er.findAll();
		
		elementos.stream().forEach(x -> {
			log.info("CONTENIDO: "+x.getIdEstudiante()+" - "+x.getNombres()+" "+x.getComportamiento().getDescripcion());
		});
		
		return elementos;
	}

	@Override
	public Estudiante buscarPorId(int idEstudiante) {
		// TODO Auto-generated method stub
		return er.getOne(idEstudiante);
	}

	@Override
	public Estudiante agregarNuevoEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return er.save(estudiante);
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		er.save(estudiante);
	}

	@Override
	public void borrarEstudiantePorId(int idEstudiante) {
		// TODO Auto-generated method stub
		er.delete(idEstudiante);
	}
	
	
	
	

}
