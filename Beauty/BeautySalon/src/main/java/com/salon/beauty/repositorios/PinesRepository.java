package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Pines;

@Repository
public interface PinesRepository extends JpaRepository<Pines, Integer> {

}
