package com.example.demo.uce.edu.service;

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

	
	
}
