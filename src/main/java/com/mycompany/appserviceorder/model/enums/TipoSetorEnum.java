/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.appserviceorder.model.enums;

/**
 *
 * @author Administrador
 */
public enum TipoSetorEnum {
    
    MANUTENCAO("Manutenção"),
    VENDAS("Vendas"),
    SUPORTE("Suporte"),
    NAO_APLICA("N/A"); 

    private final String descricao;

    TipoSetorEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
