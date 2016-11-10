package com.stefanini.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Veiculos;
import com.stefanini.service.VeiculosService;

@Named( "veiculosMB")
@SessionScoped
public class VeiculosBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    private VeiculosService veiculosService;
	
	@Inject
	private Veiculos veiculos;
   
	public Veiculos getVeiculos() {
		if(veiculos == null){
			veiculos = new Veiculos();
		}
		return veiculos;
	}
	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}
	
	
	public String chamar() {
		veiculosService.incluir(veiculos);
		this.veiculos = new Veiculos();
        return "index";
    }
}