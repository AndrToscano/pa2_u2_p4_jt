package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;

public interface CuentaBancariaRepository {

	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria seleccionar(Integer id);
	public void eliminar(Integer id);
}
