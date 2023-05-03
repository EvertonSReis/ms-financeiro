package com.msfinanceiro.servicos;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Conta;
import com.msfinanceiro.modelo.entidades.Loja;
import com.msfinanceiro.modelo.parsers.ContaParser;
import com.msfinanceiro.repositorios.ContaRepository;
import com.msfinanceiro.repositorios.LojaRepository;
import com.msfinanceiro.uteis.ContaEntradaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContaServico {

    @Autowired ContaRepository contaRepository;
    @Autowired LojaRepository lojaRepository;
    @Autowired ContaParser contaParser;
    @Autowired ContaEntradaUtil contaEntradaUtil;

    public List<ContaRetornoDTO> salvar(ContaEntradaDTO contaEntradaDTO){

        Loja loja =
                lojaRepository.findByNomeLoja(contaEntradaDTO.getLoja().getNomeLoja())
                        .orElseThrow(); //TODO criar validação.

        List<Conta> contas = new ArrayList<>();
        for(int i=1; i<= contaEntradaDTO.getTotalParcela(); i++){
            LocalDate dataVencimento = contaEntradaDTO.getDtEmissao().plusMonths(i);

            contaEntradaDTO.setNumeroParcela(i);
            contaEntradaDTO.setDtVencimento(dataVencimento);
            Conta conta =
                    contaRepository.save(
                            contaParser.parserContaEntradaDTO(contaEntradaDTO, loja));
            contas.add(conta);
        }

        return contaParser.builderListaContaRetorno(contas);
    }

    public ContaRetornoDTO atualizar(ContaEntradaDTO contaEntradaDTO, Long idConta) {

        Conta conta =
                contaRepository.findById(idConta)
                        .orElseThrow();

        Conta retornoConta = contaEntradaUtil.verificarDTONull(contaEntradaDTO, conta);

        return contaParser.builderRetornoConta(
                    contaRepository.save(retornoConta));
    }

    public void deletar(Long idConta) {

        Conta conta =
                contaRepository.findById(idConta)
                        .orElseThrow();//TODO verificar exception

        contaRepository.delete(conta);
    }

    public List<ContaRetornoDTO> retornarTodasContas() {

        List<Conta> contas = contaRepository.findAll();

        return contaParser.builderListaContaRetorno(contas);
    }
}
