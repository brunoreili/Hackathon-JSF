package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
import com.stefanini.model.Infracoes;
import com.stefanini.model.Modelo;
import com.stefanini.service.CategoriaService;
import com.stefanini.service.ModeloService;

@Named( "modeloMB")
@SessionScoped
public class ModeloBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    private ModeloService modeloService;
	
	@Inject
	private Modelo modelo;
	
	@Inject
	private CategoriaService categoriaService;
	
	private Integer idCategoria;
   
	public Modelo getModelo() {
		if(modelo == null){
			modelo = new Modelo();
		}
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}	
	
	/*
	public String chamar() {
		modeloService.incluir(modelo);
		this.modelo = new Modelo();
        return "index";
    }
    */
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	private Collection<Categoria> listaCategoria = new ArrayList<Categoria>();
	private Collection<Modelo> lista = new ArrayList<Modelo>();
	
	@PostConstruct
	public void inicia(){
		listaCategoria = categoriaService.listar();
		lista = modeloService.listar();
	}
	
	public void cadastrarInfracoes(){
		
		Categoria categ = new Categoria();
		for(Categoria ct : listaCategoria){
			if(ct.getIdCategoria().equals(this.idCategoria)){
				categ = ct;
			}
		}
		this.modelo.setCategoria(categ);
		this.modeloService.incluir(this.modelo);
		this.modelo = new Modelo();
	}
	
	/*public Collection<String> todosModelo(){
	Collection<Modelo> colecao = modeloService.listar();
	Collection<String> descricao = new ArrayList<String>();
	for(Modelo tipo : colecao){
		String descTipo = tipo.getDescricaoModelo();
		descricao.add(descTipo);
		}
	return descricao;
	}*/
}