package com.msfinanceiro.modelo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatus {

    ABERTO("ABERTO"),
    PAGO("PAGO"),
    VENCIDO("VENCIDO");

    private String nome;
}
