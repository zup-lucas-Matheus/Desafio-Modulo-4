package com.br.zup.ecommerceZUP.dominio;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Compra {

    private Cliente cliente;
    private LocalDate date;
    private List<Produto> produtosDoCliente = new ArrayList<>();

}

