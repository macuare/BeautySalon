package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Locales;
import com.salon.beauty.repositorios.LocalesRepository;

@Service
public class LocalServiceImpl implements LocalesService {
	
	
	@Autowired
	private LocalesRepository localesRepository;
	

	@Override
	public List<Locales> listarLocales() {
		// TODO Auto-generated method stub
		
		return localesRepository.findAll();
	}

	@Override
	public Locales buscarPorId(int idLocal) {
		// TODO Auto-generated method stub
		return localesRepository.findOne(idLocal);
	}

	@Override
	public Locales agregarNuevoLocal(Locales local) {
		// TODO Auto-generated method stub
		return localesRepository.save(local);
	}

	@Override
	public void actualizarLocal(Locales local) {
		// TODO Auto-generated method stub
		localesRepository.save(local);
	}

	@Override
	public void borrarLocalPorId(int idLocal) {
		// TODO Auto-generated method stub
		localesRepository.delete(idLocal);
	}

}
