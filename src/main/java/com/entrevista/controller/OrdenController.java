package com.entrevista.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrevista.exception.ModelNotFoundException;
import com.entrevista.model.Orden;
import com.entrevista.service.IOrdenService;



@RestController
@RequestMapping("/ordenes")
public class OrdenController {

	@Autowired
	private IOrdenService service;
	
	@GetMapping	
	public ResponseEntity<List<Orden>> listar(){
		List<Orden> lista = service.listar();
		return new ResponseEntity<List<Orden>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orden> leerPorId(@PathVariable("id") Integer id) {
		Optional<Orden> obj = service.leerPorId(id);
		if(!obj.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Orden>(obj.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Orden pac) {
		service.registrar(pac);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object>  modificar(@RequestBody Orden pac) {
		service.modificar(pac);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>  eliminar(@PathVariable("id") Integer id) {
		Optional<Orden> obj = service.leerPorId(id);
		if(!obj.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(obj.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarOrdenes/{idCliente}")
	public ResponseEntity<List<Orden>> listarOrdenesPorClienteId(@PathVariable("idCliente") Integer idcliente){
		List<Orden> lista = service.listarOrdenesPorClienteId(idcliente);
		return new ResponseEntity<List<Orden>>(lista, HttpStatus.OK);
	} 
	
}
