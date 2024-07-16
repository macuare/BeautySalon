package com.salon.beauty.servicios;

import java.util.List;

import com.salon.beauty.entidades.Clientes;

public interface ClientesService {
	
	public List<Clientes> listarClientes();
	public Clientes buscarPorId(String idCliente);
	public Clientes agregarNuevoCliente(Clientes cliente);
	public void actualizarCliente(Clientes cliente);
	public void borrarClientePorId(String idCliente);

}
