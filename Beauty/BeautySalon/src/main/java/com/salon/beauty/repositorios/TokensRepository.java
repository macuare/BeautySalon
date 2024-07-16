package com.salon.beauty.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.beauty.entidades.Tokens;

@Repository
public interface TokensRepository extends JpaRepository<Tokens, Integer> {

}
