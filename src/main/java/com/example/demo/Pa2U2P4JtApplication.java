package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;
import com.example.demo.uce.edu.service.CuentaBancariaService;


@SpringBootApplication
public class Pa2U2P4JtApplication implements CommandLineRunner{

	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		cuentaBancaria.setCedulaDePropietario("1724693740");
		cuentaBancaria.setNumero("12345");
		cuentaBancaria.setFechaDeApertura(LocalDateTime.now());
		cuentaBancaria.setSaldo(new BigDecimal(0));
		cuentaBancaria.setTipo("A");
		
		
		//CRUD
		//Inicio de deposito y apertura de la cuenta
		
		this.cuentaBancariaService.aperturar(cuentaBancaria);
		this.cuentaBancariaService.depositar(1, new BigDecimal(100));
	
		//Guardar e
		this.cuentaBancariaService.guardar(cuentaBancaria);

		//Borrar
		this.cuentaBancariaService.borrar(1);
		
	}
	
	

}
