package com.entrevista.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevista.model.Articulo;
import com.entrevista.model.DetalleOrden;
import com.entrevista.repo.IArticuloRepo;
import com.entrevista.repo.IOrdenRepo;
import com.entrevista.service.IArticuloService;

@Service
public class ArticuloServiceImpl implements IArticuloService{
	
	@Autowired
	private IArticuloRepo repo;
	
	@Autowired
	private IOrdenRepo ordenRepo;

	@Override
	public Articulo registrar(Articulo t) {
		return repo.save(t);
	}

	@Override
	public Articulo modificar(Articulo t) {
		return repo.save(t);
	}

	@Override
	public Optional<Articulo> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Articulo> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Transactional
	@Override
	public void eliminarArticuloOrden(Integer idarticulo) {
		ordenRepo.eliminarArticuloOrden(idarticulo);
		repo.deleteById(idarticulo);
		
	}

	@Override
	public List<Articulo> listarArticulosPorIds(Integer idorden) {
		List<DetalleOrden> detalles = ordenRepo.listarDetallesPorIdOrden(idorden);
		List<Integer> idsArticulos = new ArrayList<>();
		detalles.stream().forEach((det)-> {
			idsArticulos.add(det.getArticulo().getIdArticulo());
		});
		return repo.listarArticulosPorIds(idsArticulos);
	}	
}
