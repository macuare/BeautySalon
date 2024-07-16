package com.salon.beauty.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Recursos;

@Repository
public interface RecursosRepository extends JpaRepository<Recursos, Integer> {

	@Query(value = "SELECT * FROM Recursos where idServicio = ?1", nativeQuery = true)
	List<Recursos> findResourceByService(int idServicio);
	
}
