package com.msfinanceiro.repositorios;

import com.msfinanceiro.modelo.entidades.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {}
