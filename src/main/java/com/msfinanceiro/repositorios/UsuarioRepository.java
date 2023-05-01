package com.msfinanceiro.repositorios;

import com.msfinanceiro.modelo.entidades.Loja;
import com.msfinanceiro.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

    Optional<Usuario> findByEmail(String email);
}
