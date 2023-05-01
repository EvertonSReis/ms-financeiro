package com.msfinanceiro.repositorios;

import com.msfinanceiro.modelo.entidades.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

    Optional<Loja> findByNomeLoja(String nomeLoja);
}
