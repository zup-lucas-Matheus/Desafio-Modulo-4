package com.br.zup.ecommerceZUP.controller;

import com.br.zup.ecommerceZUP.dominio.Cliente;
import com.br.zup.ecommerceZUP.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) throws Exception {
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("/pesquisar")
    public Cliente pesquisarCliente(@RequestParam String cpf) throws Exception {
        return clienteService.pesquisarCliente(cpf);
    }

    @GetMapping
    public List<Cliente> mostrarClientes(){
        return clienteService.mostrarCliente();
    }

}
