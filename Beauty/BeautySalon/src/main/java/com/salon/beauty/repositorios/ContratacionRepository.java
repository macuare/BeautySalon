package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Contratacion;

@Repository
public interface ContratacionRepository extends JpaRepository<Contratacion, Integer> {

}
