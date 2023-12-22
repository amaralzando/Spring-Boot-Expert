package br.com.thegroupgasa.rest.controller;

import br.com.thegroupgasa.exception.PedidoNaoEncontratoException;
import br.com.thegroupgasa.exception.RegraNegocioException;
import br.com.thegroupgasa.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException ex) {
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }

    @ExceptionHandler(PedidoNaoEncontratoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlePedidoNaoEncontradoException(PedidoNaoEncontratoException ex) {
        return new ApiErrors(ex.getMessage());
    }
}
