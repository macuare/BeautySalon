package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Roles;

public interface RolesService {
	
	public List<Roles> listarRoles();
	public Roles buscarPorId(int idRol);
	public Roles agregarNuevoRol(Roles Rol);
	public void actualizarRol(Roles Rol);
	public void borrarRolPorId(int idRol);

}
