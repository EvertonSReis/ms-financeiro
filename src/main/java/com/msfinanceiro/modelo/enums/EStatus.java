package com.msfinanceiro.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EStatus {

    ABERTO("ABERTO"),
    PAGO("PAGO"),
    VENCIDO("VENCIDO");

    private String nome;
}
