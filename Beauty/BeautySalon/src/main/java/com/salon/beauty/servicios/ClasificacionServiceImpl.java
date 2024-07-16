package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Clasificacion;
import com.salon.beauty.repositorios.ClasificacionRepository;

@Service
public class ClasificacionServiceImpl implements ClasificacionService {
	@Autowired
	private ClasificacionRepository cr;

	@Override
	public List<Clasificacion> listarClasificaciones() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Clasificacion buscarPorId(int idClasificacion) {
		// TODO Auto-generated method stub
		return cr.findOne(idClasificacion);
	}

	@Override
	public Clasificacion agregarNuevaClasificacion(Clasificacion clasificacion) {
		// TODO Auto-generated method stub
		return cr.save(clasificacion);
	}

	@Override
	public void actualizarClasificacion(Clasificacion clasificacion) {
		// TODO Auto-generated method stub
		cr.saveAndFlush(clasificacion);

	}

	@Override
	public void borrarClasificacionPorId(int idClasificacion) {
		// TODO Auto-generated method stub
		cr.delete(idClasificacion);
	}

}
