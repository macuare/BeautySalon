package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
