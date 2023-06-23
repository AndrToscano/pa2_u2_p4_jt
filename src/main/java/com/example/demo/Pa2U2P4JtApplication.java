package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Ciudadano;
import com.example.demo.uce.edu.repository.model.Empleado;
import com.example.demo.uce.edu.service.CiudadanoService;
import com.example.demo.uce.edu.service.EmpleadoService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
	private CiudadanoService ciudadanoService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		Ciudadano ciudadano = new Ciudadano();
		Empleado empleado = new Empleado();
		
		ciudadano.setId(1);
		ciudadano.setApellido("Toscano");
		ciudadano.setNombre("Juan");
		ciudadano.setCedula("1724693740");
		
		empleado.setId(1);
		empleado.setCargo("Fiscalizador");
		empleado.setSueldo(new BigDecimal(800));

		//Relacion 
		ciudadano.setEmpleado(empleado);
		empleado.setCiudadano(ciudadano);
		
		//CRUD
		this.ciudadanoService.registrar(ciudadano);
		this.ciudadanoService.guardar(ciudadano);
		this.ciudadanoService.buscar(1);
		this.ciudadanoService.borrar(1);
		
		this.empleadoService.registrar(empleado);
		this.empleadoService.guardar(empleado);
		this.empleadoService.buscar(1);
		this.empleadoService.borrar(1);
	}
}
