package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IFavoriteStockService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    // 51 - Pesquisar o usuário no banco

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IFavoriteStockService acaoFavoritaService;

    @Autowired
    private UserConverter userConverter;

    // 52 - Consultar pelo login que vai retornar um dto
    @Override
    public UserDTO consultar(String login) {
        UserModel userModel = consultarEntidade(login);
        if (userModel != null) {
            List<FavoriteStockModel> acoes = acaoFavoritaService.listar(userModel);
            return userConverter.conveterEntidadeParaDTO(userModel, acoes);
        }
        return null;
    }

    // 53 - Consultar pelo login que retorna uma entidade
    @Override
    public UserModel consultarEntidade(String login) {
        return userRepository.findByLogin(login);
    }
}
