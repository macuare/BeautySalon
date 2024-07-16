package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer> {

}
