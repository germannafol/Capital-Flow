package com.example.demo.repository;

import com.example.demo.model.FavoriteStockModel;
import com.example.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 29 - Criar repository
// Para usar o spring claund tem que ser uma interface extendida com JPARepository - No JPARepository tem que dizer qual nosso modelo e qual o ID, o tipo de dado - Por tá trabalhando com postman será Long
public interface FavoriteStockRepository extends JpaRepository<FavoriteStockModel, Long> {
    FavoriteStockModel findByCodigoAndUsuario(String codigo, UserModel userModel);

    List<FavoriteStockModel> findByUsuario(UserModel userModel);
}
