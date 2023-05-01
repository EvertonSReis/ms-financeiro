package com.msfinanceiro.modelo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LojaEntradaDTO {

    private String nomeLoja;

    private String cpfCnpj;

}
