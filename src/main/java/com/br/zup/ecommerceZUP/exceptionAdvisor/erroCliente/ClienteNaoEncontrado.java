package com.br.zup.ecommerceZUP.exceptionAdvisor.erroCliente;

import lombok.RequiredArgsConstructor;


public class ClienteNaoEncontrado extends Exception{

    public ClienteNaoEncontrado(String message) {
        super(message);
    }
}
