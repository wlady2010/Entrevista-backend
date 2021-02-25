package com.entrevista.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entrevista.model.DetalleOrden;
import com.entrevista.model.Orden;

public interface IOrdenRepo extends JpaRepository<Orden, Integer> {
	
	@Query("from Orden ord where ord.cliente.idCliente = :idCliente")
	List<Orden> listarConsultasPorClienteId(@Param("idCliente") Integer idcliente);
	
	@Query("from DetalleOrden detord where detord.orden.idOrden = :idOrden")
	List<DetalleOrden> listarDetallesPorIdOrden(@Param("idOrden") Integer idOrden);
	
	@Modifying
	@Query("delete from DetalleOrden det where det.articulo.idArticulo = :idArticulo")
	void eliminarArticuloOrden(@Param("idArticulo") Integer idarticulo);

}
