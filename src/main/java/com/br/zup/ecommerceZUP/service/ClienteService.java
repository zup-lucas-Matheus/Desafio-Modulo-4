package com.br.zup.ecommerceZUP.service;

import com.br.zup.ecommerceZUP.dominio.Cliente;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroCliente.ClienteNaoEncontrado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    //Lista de clientes.
    private List<Cliente> clientes = new ArrayList<>();

    //Cadastrar Cliente
    public Cliente cadastrarCliente(Cliente cliente) throws Exception {

        clienteDuplicado(cliente.getCpf(), cliente.getEmail());
        clientes.add(cliente);
        return cliente;
    }

    //Verificar cliente duplicado por cpf
    public void clienteDuplicado(String cpf, String email) throws Exception {

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                throw new ClienteNaoEncontrado("Cliente já cadastrado no nosso banco de dados");
            } else if (cliente.getEmail().equals(email)) {
                throw new ClienteNaoEncontrado("Email já cadastrado no nosso banco de dados");
            }
        }

    }

    //Pesquisar Cliente pelo cpf
    public Cliente pesquisarCliente(String cpf) throws Exception {

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new ClienteNaoEncontrado("Cliente não encontrado");
    }

    //Mostrar cliente
    public List<Cliente> mostrarCliente() {
        return clientes;
    }


}
