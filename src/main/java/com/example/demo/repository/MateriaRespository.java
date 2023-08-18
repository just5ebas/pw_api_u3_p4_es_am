package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.modelo.Materia;
@Repository
@Transactional
public class MateriaRespository implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Materia seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Materia>myQuery=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.nombre=: datoMateria", Materia.class);
		myQuery.setParameter("datoMateria", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQ=this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula =: datoEstudiante", Materia.class);
		myQ.setParameter("datoEstudiante", cedula);
		return myQ.getResultList();
	}

}
