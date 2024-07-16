package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Usuarios;
import com.salon.beauty.repositorios.UsuariosRepository;


@Service
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	@Override
	public List<Usuarios> listarLosUsuarios() {
		// TODO Auto-generated method stub
		return usuariosRepository.findAll();
	}

	@Override
	public Usuarios buscarPorToken(String tokenUsuario) {
		// TODO Auto-generated method stub
		return usuariosRepository.findOne(tokenUsuario);
	}

	@Override
	public Usuarios agregarNuevoUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		return usuariosRepository.save(usuario);
		
	}

	@Override
	public void actualizarUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		usuariosRepository.save(usuario);
	}

	

	@Override
	public void borrarUsuario(String tokenUsuario) {
		// TODO Auto-generated method stub
		usuariosRepository.delete(tokenUsuario);
		
	}

	@Override
	public Usuarios buscarPorUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		return usuariosRepository.findByUsuario(nombreUsuario);
	}

	
	

}
