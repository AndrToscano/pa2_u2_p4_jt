package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		
		this.entityManager.persist(estudiante);
	}
	@Override
	public void actualizar(Estudiante estudiante) {
		
		this.entityManager.merge(estudiante);
	}
	@Override
	public Estudiante seleccionar(String cedula) {
		
		return this.entityManager.find(Estudiante.class, cedula);
	}
	@Override
	public void eliminar(String cedula) {
		
		Estudiante estudiante = this.seleccionar(cedula);
		this.entityManager.remove(estudiante);
	}
	
	//Query
	@Override
	public Estudiante seleccionarApellido(String apellido) {
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_apellido =
		
		//JPQL
		//Se mantiene las palabras reservadas
		//SELECT e FROM Estudiante e WHERE e.apellido =
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		
		return (Estudiante)myQuery.getSingleResult();
	}
	
	@Override
	public List<Estudiante> seleccionarListaApellido(String apellido) {
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.getResultList();
	}
	@Override
	public Estudiante seleccionarApellidoYNombre(String apellido, String nombre) {
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante)myQuery.getSingleResult();
	}
	
	//Typed Query
	@Override
	public Estudiante seleccionarApellidoTyped(String apellido) {
		
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido",
				                                                        Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.getSingleResult();
	}
	
}
