package com.br.zup.ecommerceZUP.dominio;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Produto {

    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

}
