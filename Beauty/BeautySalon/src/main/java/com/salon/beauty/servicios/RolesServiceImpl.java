package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Roles;
import com.salon.beauty.repositorios.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository rr;
	
	@Override
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public Roles buscarPorId(int idRol) {
		// TODO Auto-generated method stub
		return rr.findOne(idRol);
	}

	@Override
	public Roles agregarNuevoRol(Roles Rol) {
		// TODO Auto-generated method stub
		return rr.save(Rol);
	}

	@Override
	public void actualizarRol(Roles Rol) {
		// TODO Auto-generated method stub
		rr.saveAndFlush(Rol);

	}

	@Override
	public void borrarRolPorId(int idRol) {
		// TODO Auto-generated method stub
		rr.delete(idRol);
	}

}
