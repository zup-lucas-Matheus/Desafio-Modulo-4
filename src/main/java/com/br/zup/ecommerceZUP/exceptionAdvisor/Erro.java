package com.br.zup.ecommerceZUP.exceptionAdvisor;

import lombok.Data;

@Data
public class Erro {

    private String mensagem;

    public Erro(String mensagem) {
        this.mensagem = mensagem;
    }
}
