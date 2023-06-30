package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Habitacion;
import com.example.demo.uce.edu.repository.model.Hotel;
import com.example.demo.uce.edu.service.HabitacionService;
import com.example.demo.uce.edu.service.HotelService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

    @Autowired
	private HabitacionService habitacionService;
	
    @Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Hotel hotel = new Hotel();
		Habitacion habitacion = new Habitacion();
		List<Habitacion> habitaciones = new ArrayList<>();
		
		//Hotel 
		hotel.setNombre("Hilton Colon");
		hotel.setDireccion("Av. Colon");
		
		//Habitacion
		habitacion.setNumero("02");
		habitacion.setValor(new BigDecimal(120));
		habitaciones.add(habitacion);
		
		//CRUD
		
		//hotel.setHabitaciones(habitaciones);
		//this.hotelService.registrar(hotel);
		//this.hotelService.guardar(hotel);
		//this.hotelService.buscar(1);
		//this.hotelService.borrar(1);
		
		habitacion.setHotel(hotel);
		this.habitacionService.registrar(habitacion);
		this.habitacionService.guardar(habitacion);
		this.habitacionService.buscar(1);
		this.habitacionService.borrar(1);
	}
}
