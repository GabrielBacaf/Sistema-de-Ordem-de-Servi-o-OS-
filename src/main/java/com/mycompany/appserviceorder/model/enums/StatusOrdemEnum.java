/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.appserviceorder.model.enums;

/**
 *
 * @author GabrielBaca
 */
public enum StatusOrdemEnum {
    SOLICITADA("Solicitada"),
    REALIZANDO_SERVICO("Realizando Serviço"),
    FINALIZADA("Finalizada"),
    CANCELADA("Cancelada");

    private final String descricao;

    StatusOrdemEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
