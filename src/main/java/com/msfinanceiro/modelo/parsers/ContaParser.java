package com.msfinanceiro.modelo.parsers;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Conta;
import com.msfinanceiro.modelo.entidades.Loja;
import org.springframework.stereotype.Component;

@Component
public class ContaParser {


    public Conta parserContaEntradaDTO(ContaEntradaDTO contaEntradaDTO, Loja loja) {
        return Conta.builder()
                .build();
    }

    public ContaRetornoDTO builderRetornoConta(Conta cotna){
        return ContaRetornoDTO.builder()
                .build();
    }
}
