package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

// 49 - Criação do conversor do modelo
public abstract class ConversorBase<E, D> {
    public abstract D conveterEntidadeParaDTO(E entidade);

    public abstract E conveterDTOParaEntidade(D dto);

    public List<D> conveterEntidadeParaDTO(List<E> entidades) {
        List<D> dtos = new ArrayList<>();
        entidades.stream().forEach(entidade -> dtos.add(conveterEntidadeParaDTO(entidade)));
        return dtos;
    }

    public List<E> conveterDTOParaEntidade(List<D> dtos) {
        List<E> entidades = new ArrayList<>();
        dtos.stream().forEach(dto -> entidades.add(conveterDTOParaEntidade(dto)));
        return entidades;
    }
}
