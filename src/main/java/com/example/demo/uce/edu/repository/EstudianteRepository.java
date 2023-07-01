package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionar(String cedula);
	public void eliminar(String cedula);
	
	//Query
	public Estudiante seleccionarApellido(String apellido);
	public List<Estudiante> seleccionarListaApellido(String apellido);
	public Estudiante seleccionarApellidoYNombre(String apellido, String nombre);
	
	//Typed Query
	public Estudiante seleccionarApellidoTyped(String apellido);
	
	//Named Query
	public Estudiante seleccionarPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido);
	public Estudiante seleccionarPorNombreNamedQuery(String nombre);
	
	//Native Query
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido);
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido);
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre);

	//Criteria API Query
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido);

}
