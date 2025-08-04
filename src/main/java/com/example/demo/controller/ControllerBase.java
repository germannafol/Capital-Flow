package com.example.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class ControllerBase<T> {

    protected ResponseEntity<T> responserItemCreated(T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    protected ResponseEntity<T> responserItemCreatedWithURL(T object, UriComponentsBuilder uriBuilder, String path,
                                                            String codigo) {
        URI uri = uriBuilder.path(path).buildAndExpand(codigo).toUri();
        return ResponseEntity.created(uri).body(object);
    }

    protected ResponseEntity<T> responseItemNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> responserSuccess() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<T> responserSuccessWithItem(T object) {
        return ResponseEntity.status(HttpStatus.OK).body(object);
    }

    protected ResponseEntity<List<T>> responserListNull() {
        List<T> listNull = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(listNull);
    }

    protected ResponseEntity<List<T>> responseListOfItems(List<T> itens) {
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

    protected ResponseEntity<T> responseBadRequest() {
        return ResponseEntity.badRequest().build();
    }

    protected ResponseEntity<Page<T>> respondPagedItemList(Page<T> itens) {
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

}
