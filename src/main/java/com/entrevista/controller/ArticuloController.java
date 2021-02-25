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
import com.entrevista.model.Articulo;
import com.entrevista.service.IArticuloService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

	@Autowired
	private IArticuloService service;

	@GetMapping
	public ResponseEntity<List<Articulo>> listar() {
		List<Articulo> lista = service.listar();
		return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Articulo> leerPorId(@PathVariable("id") Integer id) {
		Optional<Articulo> obj = service.leerPorId(id);
		if (!obj.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Articulo>(obj.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Articulo cli) {
		service.registrar(cli);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Articulo cli) {
		service.modificar(cli);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/articuloOrden/{id}")
	public ResponseEntity<Object> eliminarArticuloOrden(@PathVariable("id") Integer id) {
		Optional<Articulo> obj = service.leerPorId(id);
		if (!obj.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminarArticuloOrden(id);
		}
		return new ResponseEntity<Object>(obj.get(), HttpStatus.OK);
	}

	@GetMapping("/obtenerDetalle/{id}")
	public ResponseEntity<List<Articulo>> listarDetalle(@PathVariable("id") Integer id) {
		List<Articulo> lista = service.listarArticulosPorIds(id);
		return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
	}
}
