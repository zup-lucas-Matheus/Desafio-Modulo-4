package com.br.zup.ecommerceZUP.service;

import com.br.zup.ecommerceZUP.dominio.Produto;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    //Lista de Produtos
    private List<Produto> produtos = new ArrayList<>();

    //Cadastrar Produto
    public void cadastrarProduto(Produto produto){
        produtos.add(produto);
    }
    //Verificar Produto já existente
    public void produtoDuplicado(String nome, String codigo) throws Exception {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome) && produto.getCodigoDoProduto().equals(codigo)) {
                throw new Exception("Produto já cadastrado");

            }
        }
    }

    //Mostrar Produtos
    public List<Produto> mostrarProdutos(){
        return produtos;
    }

}
