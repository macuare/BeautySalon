package com.salon.beauty.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Contratacion;
import com.salon.beauty.entidades.Seguridad;
import com.salon.beauty.entidades.Usuarios;

@Service
public class AutenticacionService implements UserDetailsService {

	@Autowired
	private UsuariosService usuariosService;
	@Autowired
	private SeguridadService seguridadService;
	@Autowired
	private ContratacionService contratacionService;
	//@Autowired
	//private RolesService rolesService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuarios usuario = usuariosService.buscarPorUsuario(username);
		
		
		if(usuario != null && usuario.getUsuario().equalsIgnoreCase(username)) {
			System.out.println("Encontrado "+username);
			Seguridad seguridad = seguridadService.listarSeguridad()
							.stream()
							.filter(s -> s.getUsuarios().getTokenUsuario().equalsIgnoreCase(usuario.getTokenUsuario()))
							.findFirst()
							.get();
			//analizar el caso cuanto la persona es contratada para varios salones
			Contratacion contratacion = contratacionService.listarLosContratos()					
							.stream()
							.filter(s -> s.getUsuarios().getTokenUsuario().equalsIgnoreCase(usuario.getTokenUsuario()))
							.findFirst()
							.get();
			
			List<GrantedAuthority> nivelesDeAccesos = new ArrayList<>();
			nivelesDeAccesos.add(new SimpleGrantedAuthority("ROLE_"+contratacion.getRoles().getTipo()));
			
			return new User(usuario.getUsuario(), seguridad.getClave(), nivelesDeAccesos);
			
		}else {
			System.out.println("No existe el usuario "+username);
			throw new UsernameNotFoundException("Usuario: " + username+" NO EXISTE...!!!");
		}
			                                                                                                                 
		
	}
	

}
