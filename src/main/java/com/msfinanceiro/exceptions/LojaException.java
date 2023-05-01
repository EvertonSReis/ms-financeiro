package com.msfinanceiro.exceptions;

import com.msfinanceiro.modelo.entidades.Loja;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LojaException extends RuntimeException{

    public LojaException(String msg){
        super(msg);
    }
}
