package com.msfinanceiro.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ETipoConta {

    CONTA_PAGAR(0, "PAGAR"),
    CONTA_RECEBER(1, "RECEBER");

    private int value;
    private String nome;

}
