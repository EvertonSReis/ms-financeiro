package com.msfinanceiro.modelo.parsers;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.modelo.dtos.LojaEntradaDTO;
import com.msfinanceiro.modelo.dtos.LojaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Conta;
import com.msfinanceiro.modelo.entidades.Loja;
import org.springframework.stereotype.Component;

@Component
public class LojaParser {


    public Loja parserLojaEntradaDTO(LojaEntradaDTO lojaEntradaDTO) {
        return Loja.builder()
                .build();
    }

    public LojaRetornoDTO builderRetornoLoja(Loja cotna){
        return LojaRetornoDTO.builder()
                .build();
    }
}
