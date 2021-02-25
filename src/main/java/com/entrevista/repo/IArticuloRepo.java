package com.entrevista.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entrevista.model.Articulo;

public interface IArticuloRepo extends JpaRepository<Articulo, Integer> {
	
	@Query("from Articulo art where art.idArticulo in  (:listaIdArticulos)")
	List<Articulo> listarArticulosPorIds(@Param("listaIdArticulos") List<Integer> listaIdArticulos);

}
