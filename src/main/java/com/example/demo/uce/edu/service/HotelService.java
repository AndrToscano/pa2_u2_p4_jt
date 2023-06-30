package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Hotel;

public interface HotelService {
	
	public void registrar(Hotel hotel);
	public void guardar(Hotel hotel);
	public Hotel buscar(Integer id);
	public void borrar(Integer id);

}
