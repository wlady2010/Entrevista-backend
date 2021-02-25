package com.entrevista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idArticulo;

	@Column(name = "codigo", nullable = false, length = 70)
	private String codigo;

	@Column(name = "nombre", nullable = false, length = 300)
	private String nombre;
	
	@Column(name = "valorUnitario", nullable = false, length = 10)
	private Double valorUnitario;
	
	@Column(name = "stock", nullable = false, length = 10)
	private Integer stock;

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
