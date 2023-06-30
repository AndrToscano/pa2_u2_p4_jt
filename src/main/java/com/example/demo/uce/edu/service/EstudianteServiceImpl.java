package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.EstudianteRepository;
import com.example.demo.uce.edu.repository.model.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void registrar(Estudiante estudiante) {
		
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public Estudiante buscar(String cedula) {
		
		return this.estudianteRepository.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
	
		this.estudianteRepository.eliminar(cedula);
	}

	//Query
	@Override
	public Estudiante buscarApellido(String apellido) {
		
		return this.estudianteRepository.seleccionarApellido(apellido);
	}

	@Override
	public List<Estudiante> buscarListaApellido(String apellido) {
		
		return this.estudianteRepository.seleccionarListaApellido(apellido);
	}

	@Override
	public Estudiante buscarApellidoYNombre(String apellido, String nombre) {
		
		return this.estudianteRepository.seleccionarApellidoYNombre(apellido, nombre);
	}

	
	//Typed Query
	@Override
	public Estudiante buscarApellidoTyped(String apellido) {
		
		return this.estudianteRepository.seleccionarApellidoTyped(apellido);
	}

	
	
	
}
