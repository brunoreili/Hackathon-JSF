package com.stefanini.repository;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Modelo;

public class ModeloRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Modelo modelo) {
		this.manager.persist(modelo);
	}

	public void altera(Modelo modelo) {
		this.manager.merge(modelo);
	}

	public Modelo busca(Integer id) {
		return this.manager.find(Modelo.class, id);
	}

	public List<Modelo> lista() {
		return this.manager.createQuery("select c from modelo c", Modelo.class)
				.getResultList();
	}

	/*public Collection<Modelo> listar() {
		// TODO Auto-generated method stub
		Query q = manager.createQuery("SELECT p FROM Modelo p");
		return (Collection<Modelo>) q.getResultList();
	}*/
}