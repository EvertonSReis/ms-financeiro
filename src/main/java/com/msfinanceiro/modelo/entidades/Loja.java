package com.msfinanceiro.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loja")
@Entity
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja_sequence")
    @SequenceGenerator(name = "loja_sequance", sequenceName = "loja_seq")
    private Long idLoja;

    private String nomeLoja;

    private String cpfCnpj;

    @OneToOne
    private Conta conta;
}
