package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Habitacion;

public interface HabitacionService {

	public void registrar(Habitacion habitacion);
	public void guardar(Habitacion habitacion);
	public Habitacion buscar(Integer id);
	public void borrar(Integer id);
}
