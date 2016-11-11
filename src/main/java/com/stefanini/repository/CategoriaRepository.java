package com.stefanini.repository;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.stefanini.model.Categoria;

public class CategoriaRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Categoria categoria) {
		this.manager.persist(categoria);
	}

	public void altera(Categoria categoria) {
		this.manager.merge(categoria);
	}

	public Categoria busca(Integer id) {
		return this.manager.find(Categoria.class, id);
	}
	
	public void remove(Integer id) {
		this.manager.remove(manager.find(Categoria.class, id));
	}

	public List<Categoria> lista() {
		return this.manager.createQuery("select c from categoria c", Categoria.class)
				.getResultList();
	}
	
	public Collection<Categoria> listar() {
		// TODO Auto-generated method stub
		Query q = manager.createQuery("SELECT p FROM Categoria p");
		return (Collection<Categoria>) q.getResultList();
	}
}
