package com.msfinanceiro.modelo.parsers;

import com.msfinanceiro.modelo.dtos.LojaEntradaDTO;
import com.msfinanceiro.modelo.dtos.LojaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Loja;
import org.springframework.stereotype.Component;

@Component
public class LojaParser {


    public Loja parserLojaEntradaDTO(LojaEntradaDTO lojaEntradaDTO) {
        return Loja.builder()
                .nomeLoja(lojaEntradaDTO.getNomeLoja())
                .cpfCnpj(lojaEntradaDTO.getCpfCnpj())
                .build();
    }

    public LojaRetornoDTO builderRetornoLoja(Loja loja){
        return LojaRetornoDTO.builder()
                .idLoja(loja.getIdLoja())
                .nomeLoja(loja.getNomeLoja())
                .cpfCnpj(loja.getCpfCnpj())
                .build();
    }
}
