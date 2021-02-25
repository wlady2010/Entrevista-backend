package com.entrevista.service;

import java.util.List;

import com.entrevista.model.Articulo;

public interface IArticuloService extends ICRUD<Articulo> {
	
	void eliminarArticuloOrden(Integer idarticulo);
	
	List<Articulo> listarArticulosPorIds (Integer idorden);

}
