package com.br.zup.ecommerceZUP.exceptionAdvisor.erroCliente;

import com.br.zup.ecommerceZUP.exceptionAdvisor.Erro;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class MensagemDeErroCliente {

    private int statusCode;
    private List<Erro> erros = new ArrayList<>();

    public MensagemDeErroCliente(int statusCode, List<Erro> erros) {
        this.statusCode = statusCode;
        this.erros = erros;
    }
}
