package com.br.zup.ecommerceZUP.service;

import com.br.zup.ecommerceZUP.dominio.Cliente;
import com.br.zup.ecommerceZUP.dominio.Compra;
import com.br.zup.ecommerceZUP.dominio.Produto;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroCompra.CompraErro;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CompraService {

    private List<Compra> compras = new ArrayList<>();

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    //Metódo para efetuar uma comprar para meu cliente
    public Compra efetuarCompra(String cpf, List<Produto> produtos) throws Exception {
        var cliente = clienteService.pesquisarCliente(cpf);
        var compra = new Compra();
        compra.setDate(LocalDate.now());
        compra.setCliente(cliente);

        for (Produto produto : produtos) {
            var produtoEncontrado = produtoService.localizarProduto(produto.getCodigoDoProduto());
            validarQuantidadeDeProduto(produto, produtoEncontrado);
            produto.setDescricao(produtoEncontrado.getDescricao());
            produto.setPreco(produtoEncontrado.getPreco());
            produto.setNome(produtoEncontrado.getNome());
            compra.getProdutosDoCliente().add(produto);
        }
        compras.add(compra);
        return compra;
    }

    //Metódo de validação da quantidade de produto que não pode ser < que 0.
    public void validarQuantidadeDeProduto(Produto produtoComprado, Produto produtoCadastrado) throws Exception {
        if (produtoComprado.getQuantidade() > produtoCadastrado.getQuantidade()) {
            throw new CompraErro("Produto em falta");
        }
        if (produtoComprado.getQuantidade() <= 0) {
            throw new CompraErro("Sem produto no estoque");
        }
    }

    //Metódo para mostrar todos os clientes com suas compras.
    public List<Compra> mostrarCompra() {
        return compras;
    }

    //Metódo para localiza o cliente com suas compras
    public Compra localizarClientePorCompra(String cpf) throws Exception {
        for (Compra compra : compras){
            if (compra.getCliente().getCpf().equals(cpf)) {
                return compra;
            }
        }
        throw new CompraErro("Cliente não encontrado");
    }
}