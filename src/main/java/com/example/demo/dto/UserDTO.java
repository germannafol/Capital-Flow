package com.example.demo.dto;

import com.example.demo.model.FavoriteStockModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

// 55 - Criação do UsuarioDTO - Dado exposto - Usuário sem ID - Controle pelo login. Questão de segurança evitar expor ID pela api
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String login;
    private String senha;
    private String email;
    private String nome;
    private List<FavoriteStockModel> acoesFavorita;
    private Boolean ativo;
}
