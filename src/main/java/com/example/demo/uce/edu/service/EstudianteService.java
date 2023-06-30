package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Estudiante;

public interface EstudianteService {

	public void registrar(Estudiante estudiante);
	public void guardar(Estudiante estudiante);
	public Estudiante buscar(String cedula);
	public void borrar(String cedula);
	
	//Query
	public Estudiante buscarApellido(String apellido);
	public List<Estudiante> buscarListaApellido(String apellido);
	public Estudiante buscarApellidoYNombre(String apellido, String nombre);
		
	//Typed Query
	public Estudiante buscarApellidoTyped(String apellido);
}
