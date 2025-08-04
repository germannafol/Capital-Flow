package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.FavoriteStockDTO;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.model.UserModel;

public interface IFavoriteStockService {

	FavoriteStockModel save(FavoriteStockModel favoriteStockModel);

	FavoriteStockDTO save(FavoriteStockDTO favoriteStockDTO);

	List<FavoriteStockModel> list(UserModel userModel);

	List<FavoriteStockModel> listNoDuplicity();
}
