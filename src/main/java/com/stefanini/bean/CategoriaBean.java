package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Categoria;
import com.stefanini.service.CategoriaService;




@Named( "categoriaMB")
@SessionScoped
public class CategoriaBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    private CategoriaService categoriaService;
	
	@Inject
	private Categoria categoria;
	
	private Collection<Categoria> lista = new ArrayList<Categoria>();
	
	@PostConstruct
	public void inicia() {
		lista = categoriaService.listar();
	}
	
	public Categoria getCategoria() {
		if(categoria == null){
			categoria = new Categoria();
		}
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Collection<Categoria> getLista() {
		return lista;
	}
	
	public void setLista(Collection<Categoria> lista) {
		this.lista = lista;
	}
	
	public void salvar() {

		try {
			categoriaService.incluir(getCategoria());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aten��o", "Salvo com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Falha ao salvar!"));
		}
		this.categoria = new Categoria();
	}
	
	/*
	public String chamar() {
		categoriaService.incluir(categoria);
		this.categoria = new Categoria();
        return "index";
    }
    */
	
	public void alterar() {

		/* buscar o id e para verificar se est� na lista */
		try {
			buscaId();
			categoriaService.alterar(this.categoria);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aten��o", "Tipo de infra��o alterado com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Tipo de infra��o n�o alterado!"));
		}

		this.categoria = new Categoria();

	}
	
	public void remover() {

		try {

			buscaId();
			categoriaService.remover(this.categoria.getIdCategoria());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aten��o", "Tipo de infra��o removido com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Tipo de infra��o n�o removido!"));
		}
		this.categoria = new Categoria();
	}
	
	public String voltar() {
		return "/index.faces?faces-redirect=true";

	}
	
	private void buscaId() throws Exception {
		inicia();
		for (Categoria ct : lista) {
			if (ct.getIdCategoria().equals(this.categoria.getIdCategoria())) {
				return;
			}
		}
		throw new Exception();
	}
	
	public Collection<Categoria> listar(){
		return this.categoriaService.listar();
	}
}