package com.stefanini.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.service.AgenteService;

@Named( "agenteMB")
@ManagedBean
@SessionScoped
public class AgenteBean {

    @Inject
    private AgenteService agenteService;
    
    private String nome;
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String chamar() {
        return "/pages/teste";
    }

}
