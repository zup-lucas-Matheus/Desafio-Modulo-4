package com.br.zup.ecommerceZUP.exceptionAdvisor.erroCompra;

import com.br.zup.ecommerceZUP.exceptionAdvisor.Erro;
import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class CompraErro extends Exception{

    public CompraErro(String message) {
        super(message);
    }
}
