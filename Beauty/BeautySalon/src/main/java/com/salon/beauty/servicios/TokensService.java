package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Tokens;

public interface TokensService {
	
	public List<Tokens> listarTokens();
	public Tokens buscarPorId(int idToken);
	public Tokens agregarNuevoToken(Tokens token);
	public void actualizarToken(Tokens token);
	public void borrarPorTokenPorId(int idToken);

}
