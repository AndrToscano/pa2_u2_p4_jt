package com.example.demo.uce.edu.repository.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "automovil", schema = "public")
@Entity
public class Automovil {

	@Id
	@SequenceGenerator(name = "seq_automovil", sequenceName = "seq_automovil", allocationSize = 1)
	@GeneratedValue(generator = "seq_automovil", strategy = GenerationType.SEQUENCE)
	@Column(name = "auto_id")
	private Integer id;
	
	@Column(name = "auto_marca")
	private String marca;
	
	@Column(name = "auto_modelo")
	private String modelo;
	
	@Column(name = "auto_anio")
	private Integer anio;
	
	@Column(name = "auto_precio")
	private BigDecimal precio;

	
	
	@Override
	public String toString() {
		return "Automovil [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", precio="
				+ precio + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	
}
