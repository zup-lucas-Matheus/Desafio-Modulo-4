package com.br.zup.ecommerceZUP.service;

import com.br.zup.ecommerceZUP.dominio.Produto;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroProduto.ProdutoErro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    //Lista de Produtos
    private List<Produto> produtos = new ArrayList<>();

    //Cadastrar Produto
    public void cadastrarProduto(Produto produto) throws Exception {
        produtoDuplicado(produto.getNome(), produto.getCodigoDoProduto());
        produtos.add(produto);

    }
    //Verificar Produto já existente
    public void produtoDuplicado(String nome, String codigo) throws Exception {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome) && produto.getCodigoDoProduto().equals(codigo)) {
                throw new ProdutoErro("Produto já cadastrado");
            }
        }

    }

    //Mostrar Produtos
    public List<Produto> mostrarProdutos(){

        return produtos;
    }

    //Localizar Produto pelo codigo do mesmo.
    public Produto localizarProduto(String codigoDoProduto) throws Exception {
        for (Produto produto: produtos) {
            if (produto.getCodigoDoProduto().equals(codigoDoProduto)) {
                return produto;
            }
        }
        throw new ProdutoErro("Produto não encontrado");
    }

    //Localizar Produtos pelo preço
    public Produto localizarProdutosPorPreco(double preco) throws ProdutoErro {
        for (Produto produto: produtos) {
            if (produto.getPreco() <= 0 ) {
                throw new ProdutoErro("Produto não existe com esse valor");
            }
            else {
                return produto;
            }
        }

        throw new ProdutoErro("Produto não encontrado");

    }



}
