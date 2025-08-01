package com.example.demo.controller;

import com.example.demo.dto.FavoriteStockDTO;
import com.example.demo.service.impl.FavoriteStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 44 - esse endpoint é que app vai bater e não é a API B3
@RequestMapping("/acoes")
public class FavoriteStockController extends ControllerBase<FavoriteStockDTO> {

    @Autowired
    private FavoriteStockService acaoFavoritaService;

    // 45 - Ação no app de salvar uma ação favorita pelo usuário
    @PostMapping("/favorita")
    public ResponseEntity<FavoriteStockDTO> salvar(
            @RequestBody
            @Validated
            FavoriteStockDTO favoriteStockDTO
    ) {
        FavoriteStockDTO acaoFavoritaRetorno = acaoFavoritaService.salvar(favoriteStockDTO);
        return responderSucessoComItem(acaoFavoritaRetorno);
    }
}
