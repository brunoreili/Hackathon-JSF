package com.stefanini.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;

@Path("/agente")
@RequestScoped
public class AgenteController {
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Agente> get() {
		 
		 List<Agente> listaAgente = new ArrayList<Agente>();
		 Agente agente1 = new Agente();
		 Agente agente2 = new Agente();
	    
		 agente1.setIdAgente(1);
		 agente1.setNome("Diogo");
		 agente1.setDtContratacao(new Date(2016-04-05));
		 agente1.setTempoServico(11);
		 
		 listaAgente.add(agente1);
		 
		 agente2.setIdAgente(2);
		 agente2.setNome("Zezinho");
		 agente2.setDtContratacao(new Date(2016-04-15));
		 agente2.setTempoServico(1);
		 
		 listaAgente.add(agente2);
		 
		 return listaAgente;
	    }

}
