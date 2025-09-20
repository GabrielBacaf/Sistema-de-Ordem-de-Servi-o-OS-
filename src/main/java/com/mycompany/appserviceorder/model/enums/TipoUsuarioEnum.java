package com.mycompany.appserviceorder.model.enums;

/**
 *
 * @author GabrielBaca
 */
public enum TipoUsuarioEnum {
    TECNICO("Técnico de manutenção"),
    CLIENTE("Cliente"),
    USUARIO_COMUM("Usuário Comum"),
    ADMINISTRADOR("Administrador - TI");

    private final String descricao;

    TipoUsuarioEnum(String descricao) {
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
