package com.msfinanceiro.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ERole {

    USER(0, "USER"),
    ADMIN(1, "ADMIN");

    private int value;
    private String nome;
}
