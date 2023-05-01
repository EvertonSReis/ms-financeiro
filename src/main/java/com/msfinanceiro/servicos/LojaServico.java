package com.msfinanceiro.servicos;

import com.msfinanceiro.exceptions.LojaException;
import com.msfinanceiro.modelo.dtos.LojaEntradaDTO;
import com.msfinanceiro.modelo.dtos.LojaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Loja;
import com.msfinanceiro.modelo.parsers.LojaParser;
import com.msfinanceiro.repositorios.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LojaServico {

    @Autowired LojaRepository lojaRepository;
    @Autowired LojaParser lojaParser;

    public LojaRetornoDTO salvar(LojaEntradaDTO lojaEntradaDTO){

        validarLojaExiste(lojaEntradaDTO);

        Loja loja =
                lojaRepository.save(
                        lojaParser.parserLojaEntradaDTO(lojaEntradaDTO));

        return lojaParser.builderRetornoLoja(loja);
    }

    private void validarLojaExiste(LojaEntradaDTO lojaEntradaDTO){
        Optional<Loja> loja = lojaRepository.findByNomeLoja(lojaEntradaDTO.getNomeLoja());//TODO inserir validação

        if(loja.isPresent()){throw new LojaException("Loja informada já foi cadastrada");}
    }
}
