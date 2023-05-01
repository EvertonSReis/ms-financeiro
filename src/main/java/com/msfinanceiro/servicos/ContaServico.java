package com.msfinanceiro.servicos;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Conta;
import com.msfinanceiro.modelo.entidades.Loja;
import com.msfinanceiro.modelo.parsers.ContaParser;
import com.msfinanceiro.repositorios.ContaRepository;
import com.msfinanceiro.repositorios.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServico {

    @Autowired ContaRepository contaRepository;
    @Autowired LojaRepository lojaRepository;
    @Autowired ContaParser contaParser;

    public ContaRetornoDTO salvar(ContaEntradaDTO contaEntradaDTO){

        Loja loja =
                lojaRepository.findByNomeLoja(contaEntradaDTO.getLoja().getNomeLoja())
                        .orElseThrow(); //TODO criar validação.

        Conta conta =
                contaRepository.save(
                        contaParser.parserContaEntradaDTO(contaEntradaDTO, loja));

        return contaParser.builderRetornoConta(conta);
    }
}
