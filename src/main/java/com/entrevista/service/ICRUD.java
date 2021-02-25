package com.entrevista.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
	//objeto generico
	
	T registrar(T t);
	T modificar(T t);
	Optional<T> leerPorId(Integer id);
	List<T> listar();
	void eliminar(Integer id);
}

