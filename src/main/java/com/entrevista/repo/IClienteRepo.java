package com.entrevista.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevista.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
