package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Integer>{

}
