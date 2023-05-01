package com.msfinanceiro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioException extends FinanceiroException{

    public UsuarioException(String msg){
        super(msg);
    }
}
