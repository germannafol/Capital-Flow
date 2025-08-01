package com.example.demo.converter;

import com.example.demo.dto.FavoriteStockDTO;
import com.example.demo.model.FavoriteStockModel;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

// 50 - Conversores
public class FavoriteStockConverter extends ConversorBase<FavoriteStockModel, FavoriteStockDTO> {

    @Autowired
    private IUserService usuarioService;

    @Override
    public FavoriteStockDTO conveterEntidadeParaDTO(FavoriteStockModel entidade) {
        return FavoriteStockDTO.builder().codigo(entidade.getCodigo()).build();
    }

    @Override
    public FavoriteStockModel conveterDTOParaEntidade(FavoriteStockDTO dto) {
        return FavoriteStockModel
                .builder()
                .codigo(dto.getCodigo())
                .userModel(usuarioService.consultarEntidade(dto.getLoginUsuario()))
                .build();
    }
}
