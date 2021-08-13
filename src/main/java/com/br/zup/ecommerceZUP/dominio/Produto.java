package com.br.zup.ecommerceZUP.dominio;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Produto {

    private String nome;
    private String descricao;
    private String codigoDoProduto;
    private int quantidade;
    private double preco;

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
}
