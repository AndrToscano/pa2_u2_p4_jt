package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Estudiante;
import com.example.demo.uce.edu.service.EstudianteService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
    private EstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Estudiante estudiante = new Estudiante();
		List<Estudiante> estudiantes = new ArrayList<>();
		
		estudiante.setApellido("Silva");
		estudiante.setNombre("Jose");
		estudiante.setEdad("24");
		estudiante.setCedula("1754289620");
		
		
		//Query
		//this.estudianteService.registrar(estudiante);
		//this.estudianteService.guardar(estudiante);
		System.out.println(this.estudianteService.buscarApellido("Silva"));
		
		  //Lista
		estudiantes = this.estudianteService.buscarListaApellido("Toscano");
		for(Estudiante e: estudiantes) {
			System.out.println(e);
		}
		
		System.out.println(this.estudianteService.buscarApellidoYNombre("Toscano", "Andres"));
		
		//Typed
		System.out.println(this.estudianteService.buscarApellidoTyped("Silva"));
	}
}
