package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude={"usuario"})
@Entity
@Table(name = "ACOES_FAVORITAS")
public class FavoriteStockModel extends EntityBaseModel {

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "AF_USUARIO_ID", nullable = false)
    private UserModel userModel;

    @Column(name = "AF_CODIGO", nullable = false)
    private String codigo;

}
