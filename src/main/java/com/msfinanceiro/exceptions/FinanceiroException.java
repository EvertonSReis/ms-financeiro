package com.msfinanceiro.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FinanceiroException extends RuntimeException{

    @Getter private String descricao;

    public FinanceiroException(String msg){
        super(msg);
        this.descricao = msg;
    }

    public FinanceiroException(Throwable causa){
        super(causa);

        this.descricao = causa.getMessage();

        if(causa instanceof FinanceiroException) {
            this.descricao = ((FinanceiroException) causa).getDescricao();
        }
    }

    public FinanceiroException(String msg, Throwable causa){
        super(msg, causa);
        this.descricao = msg;
    }
}
