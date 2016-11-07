package com.stefanini.bean;

import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.service.DenunciaService;

@Named( "denunciaMB")
public class DenunciaBean {

    @Inject
    private DenunciaService denunciaService;

    public String chamar() {
        return "/pages/teste";
    }

}
