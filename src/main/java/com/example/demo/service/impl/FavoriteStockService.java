package com.example.demo.service.impl;

import com.example.demo.converter.FavoriteStockConverter;
import com.example.demo.dto.FavoriteStockDTO;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.FavoriteStockRepository;
import com.example.demo.service.IFavoriteStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 25 - No repositório está usando a injeção de dependência para o services
@Service
public class FavoriteStockService implements IFavoriteStockService {

    @Autowired
    private FavoriteStockRepository favoriteStockRepository;

    @Autowired
    private FavoriteStockConverter favoriteStockConverter;

    @Override
    public FavoriteStockModel save(FavoriteStockModel favoriteStockModel) {
        return favoriteStockRepository.save(favoriteStockModel);
    }

    @Override
    public List<FavoriteStockModel> list(UserModel userModel) {
        List<FavoriteStockModel> acoes = new ArrayList<>();

        if (userModel != null) {
            acoes = favoriteStockRepository.findByUsuario(userModel);
        }

        return acoes;
    }

    // 26 - Realizar consulta na pasta repositório para acessar o banco de dados e identificar as ações favoritas de cada cliente e listar

    // 28 - Criar mét odo para ser usado no Job
    @Override
    public List<FavoriteStockModel> listNoDuplicity() {
        // 31 - Para não ser feita uma query personalizada, usar o distinct do java funcional distict retorna uma lista pelo código e retorne a lista, da APM do stream,
        return favoriteStockRepository.findAll().stream().distinct().collect(Collectors.toList());
    }

    // 46 - Tem que consultar no banco de dados se ação favorita já está salva. Primeiro, precisa transformar ela em modelo
    @Override
    public FavoriteStockDTO save(FavoriteStockDTO favoriteStockDTO) {
        // 47 -  tem que consulta a ação, mas apenas sendo um modelo - DTO -> Modelo -> DTO - Pode usar modelMapper do spring
        FavoriteStockModel favoriteStockModel = favoriteStockConverter.convertDTOForEntity(favoriteStockDTO);
        // 48 - Ação da consulta se ela existe nos bancos de dados, se ela não existe, salvar ela
        validar(favoriteStockModel);
        FavoriteStockModel acaoSalva = favoriteStockRepository.save(favoriteStockModel);
        return favoriteStockConverter.convertEntityForDTO(acaoSalva);
    }

    private void validar(FavoriteStockModel favoriteStockModel) {
        FavoriteStockModel acao = consultar(favoriteStockModel);

        if (acao != null) {
            throw new BusinessException("A ação já está cadastrada para este usuário. Consulte a listagem.");
        }

    }

    private FavoriteStockModel consultar(FavoriteStockModel favoriteStockModel) {
        return favoriteStockRepository.findByCodigoAndUsuario(favoriteStockModel.getCodigo(), favoriteStockModel.getUserModel());
    }

}
