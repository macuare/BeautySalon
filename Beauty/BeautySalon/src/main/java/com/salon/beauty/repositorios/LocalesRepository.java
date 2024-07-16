package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Locales;

@Repository
public interface LocalesRepository extends JpaRepository<Locales, Integer> {

}