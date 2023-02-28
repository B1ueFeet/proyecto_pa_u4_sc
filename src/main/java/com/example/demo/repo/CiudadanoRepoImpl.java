package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Ciudadano> buscarTodos() {
		Query query = this.manager.createNativeQuery("select * from ciudadano_p", Ciudadano.class);
		return query.getResultList();
	}
}
