package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Autor;
import com.example.demo.uce.edu.repository.model.Libro;
import com.example.demo.uce.edu.service.LibroService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
    private LibroService libroService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Autor autor1 = new Autor();
		Autor autor2 = new Autor();
		Autor autor3 = new Autor();
		
		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		
		
		Set<Autor> autores1 = new HashSet<>();
		Set<Autor> autores2 = new HashSet<>();
		
		Set<Libro> libros = new HashSet<>();
		
		
		
		//Autor
		autor1.setApellido("Cortazar");
		autor1.setNombre("Andres");
		
		autor2.setApellido("Silva");
		autor2.setNombre("Carlos");
		
		autor3.setApellido("Freire");
		autor3.setNombre("Daniela");
		
		//Libro
		libro1.setTitulo("Lo que el viento se llevo");
		libro1.setEditorial("AYLLA");
		
		
		libro2.setTitulo("See you");
		libro2.setEditorial("London");
		
		
		libros.add(libro1);
		libros.add(libro2);
		
		
		
		autores1.add(autor1);
		autores1.add(autor2);
		
		autores2.add(autor3);
		
		//Relacion
		autor1.setLibros(libros);
		autor2.setLibros(libros);
		autor3.setLibros(libros);
		
		libro1.setAutores(autores1);
		libro2.setAutores(autores2);
		
		
		//CRUD
		
		this.libroService.registrar(libro1);
		this.libroService.registrar(libro2);
		
		this.libroService.guardar(libro1);
		this.libroService.guardar(libro2);
		
		this.libroService.buscar(1);
		this.libroService.buscar(2);
		
		this.libroService.borrar(1);
		this.libroService.borrar(2);
	
	}
}
