package com.example.demo.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Estudiante;

@Repository
public class EstudianteRepositoryImpl implements EstudianteRepository{

	private List<Estudiante> baseDatos = new ArrayList<>();
	@Override
	public void insertar(Estudiante estudiante) {
		
		this.baseDatos.add(estudiante);
	}

}
