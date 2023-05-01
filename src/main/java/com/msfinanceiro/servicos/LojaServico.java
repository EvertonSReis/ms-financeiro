package com.msfinanceiro.servicos;

import com.msfinanceiro.modelo.dtos.LojaEntradaDTO;
import com.msfinanceiro.modelo.dtos.LojaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Loja;
import com.msfinanceiro.modelo.parsers.LojaParser;
import com.msfinanceiro.repositorios.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaServico {

    @Autowired LojaRepository lojaRepository;
    @Autowired LojaParser lojaParser;

    public LojaRetornoDTO salvar(LojaEntradaDTO lojaEntradaDTO){

        Loja loja =
                lojaRepository.save(
                        lojaParser.parserLojaEntradaDTO(lojaEntradaDTO));

        return lojaParser.builderRetornoLoja(loja);
    }
}
