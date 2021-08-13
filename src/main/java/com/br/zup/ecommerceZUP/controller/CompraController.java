package com.br.zup.ecommerceZUP.controller;

import com.br.zup.ecommerceZUP.dominio.Compra;
import com.br.zup.ecommerceZUP.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Compra compra(@RequestBody Compra compra) throws Exception {
      return compraService.efetuarCompra(compra.getCliente().getCpf(), compra.getProdutosDoCliente());

    }

    @GetMapping
    public List<Compra> mostrarCompras(){
        return compraService.mostrarCompra();
    }

    @GetMapping("/pesquisa")
    public Compra localizarCompraDoCliente(@RequestParam String cpf) throws Exception {

        return compraService.localizarClientePorCompra(cpf);
    }
}
