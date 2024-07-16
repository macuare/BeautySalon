package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Tokens;
import com.salon.beauty.repositorios.TokensRepository;

@Service
public class TokensServiceImpl implements TokensService {

	@Autowired
	TokensRepository tr;
	
	@Override
	public List<Tokens> listarTokens() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public Tokens buscarPorId(int idToken) {
		// TODO Auto-generated method stub
		return tr.findOne(idToken);
	}

	@Override
	public Tokens agregarNuevoToken(Tokens token) {
		// TODO Auto-generated method stub
		return tr.save(token);
	}

	@Override
	public void actualizarToken(Tokens token) {
		// TODO Auto-generated method stub
		tr.save(token);
	}

	@Override
	public void borrarPorTokenPorId(int idToken) {
		// TODO Auto-generated method stub
		tr.delete(idToken);
		
	}


	

}
