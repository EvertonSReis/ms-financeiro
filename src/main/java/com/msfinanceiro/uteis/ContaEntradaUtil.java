package com.msfinanceiro.uteis;

import com.msfinanceiro.modelo.dtos.ContaEntradaDTO;
import com.msfinanceiro.modelo.entidades.Conta;

public class ContaEntradaUtil {

    public Conta verificarDTONull(ContaEntradaDTO contaEntradaDTO, Conta conta){
        if(contaEntradaDTO.getValorDeCompra() != null) conta.setValorDeCompra(contaEntradaDTO.getValorDeCompra());
        if(contaEntradaDTO.getValorParcela() != null) conta.setValorParcela(contaEntradaDTO.getValorParcela());
        if(contaEntradaDTO.getNumeroParcela() != null) conta.setNumeroParcela(contaEntradaDTO.getNumeroParcela());
        if(contaEntradaDTO.getTotalParcela() != null) conta.setTotalParcela(contaEntradaDTO.getTotalParcela());
        if(contaEntradaDTO.getDtEmissao() != null) conta.setDtEmissao(contaEntradaDTO.getDtEmissao());
        if(contaEntradaDTO.getDtVencimento() != null) conta.setDtVencimento(contaEntradaDTO.getDtVencimento());
        if(contaEntradaDTO.getFormaPagamento() != null) conta.setFormaPagamento(contaEntradaDTO.getFormaPagamento());
        if(contaEntradaDTO.getStatus() != null) conta.setStatus(contaEntradaDTO.getStatus());
        if(contaEntradaDTO.getLoja() != null) conta.setLoja(contaEntradaDTO.getLoja());

    return conta;
    }
}
