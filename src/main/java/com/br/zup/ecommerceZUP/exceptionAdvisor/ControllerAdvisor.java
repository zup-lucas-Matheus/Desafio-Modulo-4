package com.br.zup.ecommerceZUP.exceptionAdvisor;

import com.br.zup.ecommerceZUP.exceptionAdvisor.erroCliente.ClienteNaoEncontrado;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroCliente.MensagemDeErroCliente;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroCompra.CompraErro;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroCompra.MenssagemErroCompra;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroProduto.MenssagemErroProduto;
import com.br.zup.ecommerceZUP.exceptionAdvisor.erroProduto.ProdutoErro;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErroCliente manipularExcecoes(MethodArgumentNotValidException exception){

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<Erro> erros = fieldErrors.stream().map(objeto -> new Erro(objeto.getDefaultMessage())).collect(Collectors.toList());
        return new MensagemDeErroCliente(400, erros);

    }

    //Erro tratado para Cliente
    @ExceptionHandler(ClienteNaoEncontrado.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErroCliente clienteNaoEncontrado(ClienteNaoEncontrado naoEncontrado){

        List<Erro> erros = Arrays.asList(new Erro(naoEncontrado.getMessage()));
        return new MensagemDeErroCliente(400, erros);

    }

    @ExceptionHandler(ProdutoErro.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //Erro tratado para Produto
    public MenssagemErroProduto produtoErro(ProdutoErro erroProduto){

        List<Erro> errosProduto = Arrays.asList(new Erro(erroProduto.getMessage()));
        var erroProdutos = new MenssagemErroProduto("Erro", errosProduto);
        return erroProdutos;
    }

    @ExceptionHandler(CompraErro.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //Erro tratado para Compras
    public MenssagemErroCompra compraErro(CompraErro erroCompra){

        List<Erro> compraErros = Arrays.asList(new Erro(erroCompra.getMessage()));
        return new MenssagemErroCompra("Xablau", compraErros);
    }

}
