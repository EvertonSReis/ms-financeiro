package com.msfinanceiro.modelo.entidades;

import com.msfinanceiro.modelo.enums.EFormaPagamento;
import com.msfinanceiro.modelo.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta_sequence")
    @SequenceGenerator(name="conta_sequence", sequenceName = "conta_seq")
    private Long idConta;

    @OneToOne(fetch = FetchType.LAZY)
    private Loja loja;

    private BigDecimal valorDeCompra;

    private BigDecimal valorParcela;

    private Integer numeroParcela;

    private Integer totalParcela;

    private LocalDate dtEmissao;

    private LocalDate dtVencimento;

    private EFormaPagamento formaPagamento;

    private EStatus status;

}
