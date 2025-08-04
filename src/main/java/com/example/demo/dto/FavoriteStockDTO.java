package com.example.demo.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
// 56 - Não incluir campos nulos na serialização JSON
@JsonInclude(Include.NON_NULL)
public class FavoriteStockDTO {

    @Nonnull
    private String loginUsuario;
    @Nonnull
    private String codigo;
}
