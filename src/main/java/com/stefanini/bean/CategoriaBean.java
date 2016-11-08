package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
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
   
	public Categoria getCategoria() {
		if(categoria == null){
			categoria = new Categoria();
		}
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public String chamar() {
		categoriaService.incluir(categoria);
		
		this.categoria = new Categoria();
        return "index";
    }
}
