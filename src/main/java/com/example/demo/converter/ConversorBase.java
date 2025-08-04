package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

// 49 - Criação do conversor do modelo
public abstract class ConversorBase<E, D> {
    public abstract D convertEntityForDTO(E entidade);

    public abstract E convertDTOForEntity(D dto);

    public List<D> convertEntityForDTO(List<E> entidades) {
        List<D> dtos = new ArrayList<>();
        entidades.stream().forEach(entidade -> dtos.add(convertEntityForDTO(entidade)));
        return dtos;
    }

    public List<E> convertDTOForEntity(List<D> dtos) {
        List<E> entidades = new ArrayList<>();
        dtos.stream().forEach(dto -> entidades.add(convertDTOForEntity(dto)));
        return entidades;
    }
}
