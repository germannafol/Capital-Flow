package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FavoriteStockDTO;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.model.UserModel;

public interface IFavoriteStockService {

	FavoriteStockModel salvar(FavoriteStockModel favoriteStockModel);

	FavoriteStockDTO salvar(FavoriteStockDTO favoriteStockDTO);

	List<FavoriteStockModel> listar(UserModel userModel);

	List<FavoriteStockModel> listarSemDuplicidade();
}
