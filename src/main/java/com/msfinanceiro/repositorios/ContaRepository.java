package com.msfinanceiro.repositorios;

import com.msfinanceiro.modelo.entidades.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "select * from conta where numero_conta = :numeroConta and numero_parcela = :numeroParcela", nativeQuery = true)
    Optional<Conta> selectContaPorNumeroContaENumeroParcela(Long numeroConta, Long numeroParcela);
    @Query(value = "select max(numero_conta) from conta", nativeQuery = true)
    Integer numeroUltimoConta();
}
