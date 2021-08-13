package com.br.zup.ecommerceZUP.controller;

import com.br.zup.ecommerceZUP.dominio.Produto;
import com.br.zup.ecommerceZUP.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarProduto(@RequestBody Produto produto) throws Exception {

        produtoService.cadastrarProduto(produto);
    }

    @GetMapping
    public List<Produto> mostrarProduto() {
        return produtoService.mostrarProdutos();
    }


    @GetMapping("/codigoProduto")
    public Produto localizarProduto(@RequestParam String codigoDoProduto) throws Exception {
        return produtoService.localizarProduto(codigoDoProduto);
    }

    @GetMapping("/preco")
    public Produto localizarProdutoPorPreco(@RequestParam double preco) throws Exception {
        return produtoService.localizarProdutosPorPreco(preco);
    }

}
