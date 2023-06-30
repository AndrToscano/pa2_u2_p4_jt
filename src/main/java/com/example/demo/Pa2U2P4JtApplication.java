package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Alumno;
import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.service.MatriculaService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
    private MatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Alumno alumno = new Alumno();
		Materia materia = new Materia();
		
		Matricula matricula = new Matricula();
		List<Matricula> matriculas = new ArrayList<>();
		
		alumno.setNombre("David");
		
		materia.setNombre("Inteligencia Artificial");
		
		matricula.setNumeroDeMatricula("C005");
		matricula.setFechaDeMatricula(LocalDateTime.now());
		
		matriculas.add(matricula);
	
		
		alumno.setMatriculas(matriculas);
		materia.setMatriculas(matriculas);
		matricula.setAlumno(alumno);
		matricula.setMateria(materia);
		
		
		//CRUD
		this.matriculaService.registrar(matricula);
		this.matriculaService.guardar(matricula);
		this.matriculaService.buscar(1);
		this.matriculaService.borrar(1);
	}
}
