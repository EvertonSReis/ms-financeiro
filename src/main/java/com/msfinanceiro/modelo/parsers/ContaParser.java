package com.msfinanceiro.modelo.parsers;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.dtos.ContaRetornoDTO;
import com.msfinanceiro.modelo.dtos.LojaRetornoDTO;
import com.msfinanceiro.modelo.entidades.Conta;
import com.msfinanceiro.modelo.entidades.Loja;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContaParser {


    public Conta parserContaEntradaDTO(ContaEntradaDTO contaEntradaDTO, Loja loja) {
        return Conta.builder()
                .valorDeCompra(contaEntradaDTO.getValorDeCompra())
                .valorParcela(contaEntradaDTO.getValorParcela())
                .numeroParcela(contaEntradaDTO.getNumeroParcela())
                .totalParcela(contaEntradaDTO.getTotalParcela())
                .dtEmissao(contaEntradaDTO.getDtEmissao())
                .dtVencimento(contaEntradaDTO.getDtVencimento())
                .formaPagamento(contaEntradaDTO.getFormaPagamento())
                .status(contaEntradaDTO.getStatus())
                .loja(loja)
                .build();
    }

    public ContaRetornoDTO builderRetornoConta(Conta conta){
        return ContaRetornoDTO.builder()
                .idConta(conta.getIdConta())
                .valorDeCompra(conta.getValorDeCompra())
                .valorParcela(conta.getValorParcela())
                .numeroParcela(conta.getNumeroParcela())
                .totalParcela(conta.getTotalParcela())
                .dtEmissao(conta.getDtEmissao())
                .dtVencimento(conta.getDtVencimento())
                .formaPagamento(conta.getFormaPagamento())
                .status(conta.getStatus())
                .loja(builderContaParaLojaRetorno(conta))
                .build();
    }

    public List<ContaRetornoDTO> builderListaContaRetorno(List<Conta> contas) {
        List<ContaRetornoDTO> contaRetornoDTOS = new ArrayList<>();
        contas.forEach(conta -> contaRetornoDTOS.add(
                ContaRetornoDTO.builder()
                        .idConta(conta.getIdConta())
                        .valorDeCompra(conta.getValorDeCompra())
                        .valorParcela(conta.getValorParcela())
                        .numeroParcela(conta.getNumeroParcela())
                        .totalParcela(conta.getTotalParcela())
                        .dtEmissao(conta.getDtEmissao())
                        .dtVencimento(conta.getDtVencimento())
                        .formaPagamento(conta.getFormaPagamento())
                        .status(conta.getStatus())
                        .loja(builderContaParaLojaRetorno(conta))
                        .build()));

        return contaRetornoDTOS;
    }

    private LojaRetornoDTO builderContaParaLojaRetorno(Conta conta){
        return LojaRetornoDTO.builder()
                .idLoja(conta.getLoja().getIdLoja())
                .nomeLoja(conta.getLoja().getNomeLoja())
                .cpfCnpj(conta.getLoja().getCpfCnpj())
                .build();
    }
}
