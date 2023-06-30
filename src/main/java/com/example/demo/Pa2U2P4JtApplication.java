package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Automovil;
import com.example.demo.uce.edu.service.AutomovilService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
    private AutomovilService automovilService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Automovil automovil = new Automovil();
		List<Automovil> automoviles =  new ArrayList<>();
		List<Automovil> automovilesTyped =  new ArrayList<>();

		automovil.setMarca("Toyota");
		automovil.setModelo("Corrolla");
		automovil.setAnio(2004);
		automovil.setPrecio(new BigDecimal(14500));
		
		//CRUD
		//this.automovilService.registrar(automovil);
		
		//Query
		//SingleResult
		System.out.println(this.automovilService.buscarModelo("Corrolla"));
		
		//ResultList
		automoviles = this.automovilService.buscarMarcaYModelo("Toyota", "Corrolla");
		for(Automovil e: automoviles) {
			System.out.println(e);
		}
		
		
		//typedQuery
		//SingleResult
		System.out.println(this.automovilService.buscarModeloTyped("Corrolla"));
		
		//ResultList
		automovilesTyped = this.automovilService.buscarPorAnio(2000);
		
		for(Automovil e: automovilesTyped) {
			System.out.println(e);
		}
	}
}
