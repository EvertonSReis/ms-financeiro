package com.msfinanceiro.modelo.entidades;

import com.msfinanceiro.modelo.enums.EFormaPagamento;
import com.msfinanceiro.modelo.enums.EStatus;
import com.msfinanceiro.modelo.enums.ETipoConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
@Entity
public class Conta {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_conta", updatable = false, nullable = false)
    private UUID idConta;

    private ETipoConta tipoConta;

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
