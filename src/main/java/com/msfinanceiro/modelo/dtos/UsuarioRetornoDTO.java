package com.msfinanceiro.modelo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msfinanceiro.modelo.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioRetornoDTO {

    private Long idUsuario;

    private String nomeUsuario;

    private String senha;

    private String email;

    private ERole role;
}
