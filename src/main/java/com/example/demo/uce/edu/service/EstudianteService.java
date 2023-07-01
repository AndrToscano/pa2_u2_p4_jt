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
	
	//Named Query
	public Estudiante buscarPorApellido(String apellido);
	public Estudiante buscarPorApellidoNamedQuery(String apellido);
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	
	//Native Query
	public Estudiante buscarPorApellidoNativeQuery(String apellido);
	public Estudiante buscarPorApellidoNativeQueryNamed(String apellido);
	public Estudiante buscarPorNombreNativeQueryNamed(String nombre);
	
	//Criteria API Query
	public Estudiante buscarPorApellidoCriteriaAPIQuery(String apellido);
}
