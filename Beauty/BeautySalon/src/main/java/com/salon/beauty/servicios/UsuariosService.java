package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Usuarios;

public interface UsuariosService {
	
	public List<Usuarios> listarLosUsuarios();	
	public Usuarios buscarPorToken(String tokenUsuario);
	public Usuarios buscarPorUsuario(String nombreUsuario);
	public Usuarios agregarNuevoUsuario(Usuarios usuario);
	public void actualizarUsuario(Usuarios usuario);
	public void borrarUsuario(String tokenUsuario);
	
	

}
