package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Automovil;

public interface AutomovilService {

	public void registrar(Automovil automovil);
	public void guardar(Automovil automovil);
	public Automovil buscar(Integer id);
	public void borrar(Integer id);
	
	//Query
	public Automovil buscarModelo(String modelo);
	public List<Automovil> buscarMarcaYModelo(String marca, String modelo);
	
		
	//Typed Query
	public Automovil buscarModeloTyped(String modelo);
	public List<Automovil> buscarPorAnio(Integer anio);
}
