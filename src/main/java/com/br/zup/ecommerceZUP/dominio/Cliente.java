package com.br.zup.ecommerceZUP.dominio;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Cliente {

    private String nome;
    private String cpf;
    private String email;


}
