package com.stefanini.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Denuncia;
import com.stefanini.repository.DenunciaRepository;

@Stateless
public class DenunciaService {

    @Inject
    private DenunciaRepository denunciaRepository;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(Denuncia denuncia){
        denunciaRepository.incluir(denuncia);
    }

}