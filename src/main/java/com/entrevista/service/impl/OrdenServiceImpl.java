package com.entrevista.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevista.model.Orden;
import com.entrevista.repo.IArticuloRepo;
import com.entrevista.repo.IOrdenRepo;
import com.entrevista.service.IOrdenService;

@Service
public class OrdenServiceImpl implements IOrdenService {
	
	@Autowired
	private IOrdenRepo repo;
	
	@Autowired
	private IArticuloRepo articuloRepo;

	@Override
	public Orden registrar(Orden t) {
		t.getDetalleOrden().forEach(det -> {
			det.setOrden(t);
		});
		t.getDetalleOrden().forEach(det ->{
			articuloRepo.save(det.getArticulo());
		});
		
		return repo.save(t);
	}

	@Override
	public Orden modificar(Orden t) {
		return repo.save(t);
	}

	@Override
	public Optional<Orden> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Orden> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}
	
	@Override
	public List<Orden> listarOrdenesPorClienteId (Integer idcliente) {
		return repo.listarConsultasPorClienteId(idcliente);
	}

}
