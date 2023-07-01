package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Automovil;

public interface AutomovilRepository {

	public void insertar(Automovil automovil);
	public void actualizar(Automovil automovil);
	public Automovil seleccionar(Integer id);
	public void eliminar(Integer id);
	
	//Query
	public Automovil seleccionarModelo(String modelo);
	public List<Automovil> seleccionarMarcaYModelo(String marca, String modelo);
	
		
	//Typed Query
	public Automovil seleccionarModeloTyped(String modelo);
	public List<Automovil> seleccionarPorAnio(Integer anio);
}