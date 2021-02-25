package com.entrevista.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevista.model.Cliente;
import com.entrevista.repo.IClienteRepo;
import com.entrevista.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepo repo;

	@Override
	public Cliente registrar(Cliente t) {
		return repo.save(t);
	}

	@Override
	public Cliente modificar(Cliente t) {
		return repo.save(t);
	}

	@Override
	public Optional<Cliente> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}
	
	
	
	
}
