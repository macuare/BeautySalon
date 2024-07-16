package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, String> {

}
