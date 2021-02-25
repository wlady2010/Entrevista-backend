package com.entrevista.service;

import java.util.List;

import com.entrevista.model.Orden;

public interface IOrdenService extends ICRUD<Orden> {
	
	List<Orden> listarOrdenesPorClienteId (Integer idcliente);

}
