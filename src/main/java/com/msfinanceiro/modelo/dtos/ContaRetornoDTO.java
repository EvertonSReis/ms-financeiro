package com.msfinanceiro.modelo.dtos;

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

    private Integer numeroConta;

    private String tipoConta;

    private LojaRetornoDTO loja;

    private BigDecimal valorDeCompra;

    private BigDecimal valorParcela;

    private Integer numeroParcela;

    private Integer totalParcela;

    private LocalDate dtEmissao;

    private LocalDate dtVencimento;

    private String formaPagamento;

    private String status;
}
