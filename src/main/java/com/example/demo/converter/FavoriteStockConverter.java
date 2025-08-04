package com.example.demo.converter;

import com.example.demo.dto.FavoriteStockDTO;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 50 - Conversores
public class FavoriteStockConverter extends ConversorBase<FavoriteStockModel, FavoriteStockDTO> {

    @Autowired
    private IUserService iUserService;

    @Override
    public FavoriteStockDTO convertEntityForDTO(FavoriteStockModel entidade) {
        return FavoriteStockDTO.builder().codigo(entidade.getCodigo()).build();
    }

    @Override
    public FavoriteStockModel convertDTOForEntity(FavoriteStockDTO dto) {
        return FavoriteStockModel
                .builder()
                .codigo(dto.getCodigo())
                .userModel(iUserService.consultEntity(dto.getLoginUsuario()))
                .build();
    }
}
