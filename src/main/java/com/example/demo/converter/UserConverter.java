package com.example.demo.converter;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// 54 - Criação do UsuarioConversor
public class UserConverter extends ConversorBase<UserModel, UserDTO> {

    @Autowired
    private FavoriteStockConverter favoriteStockConverter;

    @Override
    public UserDTO conveterEntidadeParaDTO(UserModel entidade) {
        return UserDTO.builder()
                .nome(entidade.getNome())
                .login(entidade.getLogin())
                .senha(entidade.getSenha())
                .email(entidade.getEmail())
                .ativo(entidade.getAtivo())
                .build();
    }

    public UserDTO conveterEntidadeParaDTO(UserModel userModel, List<FavoriteStockModel> acoes) {
        return UserDTO.builder()
                .nome(userModel.getNome())
                .login(userModel.getLogin())
                .senha(userModel.getSenha())
                .email(userModel.getEmail())
                .ativo(userModel.getAtivo())
                .build();
    }

    @Override
    public UserModel conveterDTOParaEntidade(UserDTO dto) {
        return null;
    }
}
