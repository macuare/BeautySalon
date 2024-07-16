package com.salon.beauty.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.beauty.entidades.Clientes;
import com.salon.beauty.repositorios.ClientesRepository;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	private ClientesRepository cr;
	
	@Override
	public List<Clientes> listarClientes() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Clientes buscarPorId(String idCliente) {
		// TODO Auto-generated method stub
		return cr.findOne(idCliente);
	}

	@Override
	public Clientes agregarNuevoCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		return cr.save(cliente);
	}

	@Override
	public void actualizarCliente(Clientes cliente) {
		// TODO Auto-generated method stub
		cr.saveAndFlush(cliente);

	}

	@Override
	public void borrarClientePorId(String idCliente) {
		// TODO Auto-generated method stub
		cr.delete(idCliente);
	}

}
