package com.msfinanceiro.modelo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ERole {

    USER("USER"),
    ADMIN("ADMIN");

    private String nome;
}
