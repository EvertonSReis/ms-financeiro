package com.msfinanceiro.modelo.dtos;

import com.msfinanceiro.modelo.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntradaDTO {

    private String nomeUsuario;

    private String senha;

    private String email;

    private ERole role;
}
