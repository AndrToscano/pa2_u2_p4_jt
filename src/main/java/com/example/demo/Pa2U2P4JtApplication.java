package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Autor;
import com.example.demo.uce.edu.repository.model.Libro;
import com.example.demo.uce.edu.service.AutorService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
    private AutorService autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Autor autor = new Autor();
		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		
		Set<Autor> autores = new HashSet<>();
		Set<Libro> libros = new HashSet<>();
		
		//Autor
		autor.setApellido("Cortazar");
		autor.setNombre("Andres");
		
		//Libro
		libro1.setTitulo("Lo que el viento se llevo");
		libro1.setEditorial("AYLLA");
		
		
		libro2.setTitulo("See you");
		libro2.setEditorial("London");
		
		libros.add(libro1);
		libros.add(libro2);
		autores.add(autor);
		
		//Relacion
		autor.setLibros(libros);
		libro1.setAutores(autores);
		libro2.setAutores(autores);
		
		//CRUD
		this.autorService.registrar(autor);
		this.autorService.guardar(autor);
		this.autorService.buscar(1);
		this.autorService.borrar(1);
	}
}
