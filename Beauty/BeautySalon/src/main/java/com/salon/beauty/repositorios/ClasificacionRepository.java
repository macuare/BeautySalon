package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Clasificacion;



@Repository
public interface ClasificacionRepository  extends JpaRepository<Clasificacion, Integer> {

}
