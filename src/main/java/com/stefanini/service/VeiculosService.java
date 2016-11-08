package com.stefanini.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Veiculos;
import com.stefanini.repository.VeiculosRepository;

@Stateless
public class VeiculosService {

    @Inject
    private VeiculosRepository veiculosRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(Veiculos veiculos){
        veiculosRepository.incluir(veiculos);
        
    }

}