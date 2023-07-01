package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
		//SELECT * FROM estudiante e WHERE e.estu_apellido = :""
		
		//JPQL
		//Se mantiene las palabras reservadas
		//SELECT e FROM Estudiante e WHERE e.apellido = :""
		
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
		
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_apellido = :"" AND e.estu_nombre = :""
				
		//JPQL
		//Se mantiene las palabras reservadas
		//SELECT e FROM Estudiante e WHERE e.apellido = :"" AND e.nombre = :""
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante)myQuery.getSingleResult();
	}
	
	//Typed Query
	@Override
	public Estudiante seleccionarApellidoTyped(String apellido) {
		
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_apellido = :""
				
		//JPQL
		//Se mantiene las palabras reservadas
		//SELECT e FROM Estudiante e WHERE e.apellido = :""
		
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido",
				                                                        Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.getSingleResult();
	}
	
	//Named Query
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		
		//name = "Estudiante.seleccionarPorApellido"
		
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.seleccionarPorApellido", Estudiante.class);
        myQuery.setParameter("datoApellido", apellido);

        return myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.seleccionarPorApellido", Estudiante.class);
        myQuery.setParameter("datoApellido", apellido);

        return (Estudiante)myQuery.getSingleResult();

	}
	@Override
	public Estudiante seleccionarPorNombreNamedQuery(String nombre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.seleccionarPorNombre", Estudiante.class);
        myQuery.setParameter("datoNombre", nombre);

        return (Estudiante)myQuery.getSingleResult();
	}
	
	//Native Query
	@Override
	public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {
		//SQL
		//SELECT * FROM estudiante WHERE estu_apellido = :datoApellidoNative
		//Hay que colocar el nombre de la tabla
		
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido = :datoApellidoNative",
				                                             Estudiante.class);
		myQuery.setParameter("datoApellidoNative", apellido);
		return (Estudiante)myQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
		
		//name = "Estudiante.seleccionarPorApellidoNative"
		
		TypedQuery<Estudiante> typedQuery = this.entityManager.createNamedQuery("Estudiante.seleccionarPorApellidoNative", Estudiante.class);
		typedQuery.setParameter("datoApellidoNative", apellido);
		return typedQuery.getSingleResult();
	}
	@Override
	public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
		
		//name = "Estudiante.seleccionarPorNombreNative"
		
		TypedQuery<Estudiante> typedQuery = this.entityManager.createNamedQuery("Estudiante.seleccionarPorNombreNative", Estudiante.class);
		typedQuery.setParameter("datoNombreNative", nombre);
		return typedQuery.getSingleResult();
	}
	
	//Criteria API Query
	@Override
	public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {
		
		// Construir desde cero el SQL
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		
		//1. Especificar el tipo de retorno del Query - Sintesis del Typed Query
		CriteriaQuery<Estudiante> mycriteriaQuery = myCriteriaBuilder.createQuery(Estudiante.class);
		
		//2. Empezamos a crear el SQL
		//2.1. Definimos el FRONT -> El FROM en Criteria API Query se lo conoce como Root
		Root<Estudiante> myTableFrom = mycriteriaQuery.from(Estudiante.class); //FROM Estudiante
		
		//3. Consturir las condiciones de mi SQL -> WHERE -> Las condiciones se las conoce como Predicacdos
		//e.apellido = :datoApellido
		Predicate condicionApellido = myCriteriaBuilder.equal(myTableFrom.get("apellido"), apellido);
		
		//4. Armamos mi SQL Final
		mycriteriaQuery.select(myTableFrom).where(condicionApellido);
		
		//5. Ejecucion del Query lo realizamos con Typed Query
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(mycriteriaQuery);
		return myQueryFinal.getSingleResult();
	}
	
}
