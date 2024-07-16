package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Locales;


public interface LocalesService {
	
	public List<Locales> listarLocales();
	public Locales buscarPorId(int idLocal);	
	public Locales agregarNuevoLocal(Locales local);
	public void actualizarLocal(Locales local);
	public void borrarLocalPorId(int idLocal);
	
}
