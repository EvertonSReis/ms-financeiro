package com.msfinanceiro.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EFormaPagamento {

    DINHEIRO("DINHEIRO"),
    CARTAO_DEBITO("CARTAO DEBITO"),
    CARTAO_CREDITO("CARTAO CREDITO"),
    PIX("PIX");

    private String nome;
}
