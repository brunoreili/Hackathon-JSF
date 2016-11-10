package com.stefanini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
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
   
	public Modelo getModelo() {
		if(modelo == null){
			modelo = new Modelo();
		}
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}	
	
	public String chamar() {
		modeloService.incluir(modelo);
		this.modelo = new Modelo();
        return "index";
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