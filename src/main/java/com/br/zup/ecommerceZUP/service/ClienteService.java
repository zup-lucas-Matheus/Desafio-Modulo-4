package com.br.zup.ecommerceZUP.service;

import com.br.zup.ecommerceZUP.dominio.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    //Lista de clientes.
    private List<Cliente> clientes = new ArrayList<>();

    //CadastrarCliente
    public Cliente cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }



}
