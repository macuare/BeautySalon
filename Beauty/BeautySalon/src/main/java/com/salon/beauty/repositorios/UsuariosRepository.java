package com.salon.beauty.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
	
	Usuarios findByUsuario(String nombreUsuario);

}
