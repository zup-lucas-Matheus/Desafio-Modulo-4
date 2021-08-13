package com.br.zup.ecommerceZUP.exceptionAdvisor.erroProduto;

import com.br.zup.ecommerceZUP.exceptionAdvisor.Erro;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenssagemErroProduto {

    private String statusCode;
    private List<Erro> erros = new ArrayList<>();

    public MenssagemErroProduto(String statusCode, List<Erro> erros) {
        this.statusCode = statusCode;
        this.erros = erros;
    }
}
