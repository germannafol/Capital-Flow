package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIOS")
public class UserModel extends EntityBaseModel {

    @Column(name = "USU_LOGIN", nullable = false)
    private String login;

    @Column(name = "USU_SENHA", nullable = false)
    private String senha;

    @Column(name = "USU_EMAIL", nullable = false)
    private String email;

    @Column(name = "USU_NOME", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<FavoriteStockModel> acoesFavoritas;

    @Column(name = "USU_ATIVO", nullable = false)
    private Boolean ativo;

}