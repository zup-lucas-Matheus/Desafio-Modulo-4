package com.br.zup.ecommerceZUP.exceptionAdvisor.erroCompra;

import com.br.zup.ecommerceZUP.exceptionAdvisor.Erro;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class MenssagemErroCompra{

    private String statusCode;
    private List<Erro> errors = new ArrayList<>();

    public MenssagemErroCompra(String statusCode, List<Erro> errors) {
        this.statusCode = statusCode;
        this.errors = errors;
    }
}
