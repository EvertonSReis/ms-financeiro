package com.msfinanceiro.modelo.dtos;

import com.msfinanceiro.modelo.enums.EFormaPagamento;
import com.msfinanceiro.modelo.enums.EStatus;
import com.msfinanceiro.modelo.enums.ETipoConta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaRetornoDTO {

    private UUID idConta;

    private ETipoConta tipoConta;

    private LojaRetornoDTO loja;

    private BigDecimal valorDeCompra;

    private BigDecimal valorParcela;

    private Integer numeroParcela;

    private Integer totalParcela;

    private LocalDate dtEmissao;

    private LocalDate dtVencimento;

    private EFormaPagamento formaPagamento;

    private EStatus status;
}
