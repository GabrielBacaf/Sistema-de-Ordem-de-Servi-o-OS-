/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.dto;

import com.mycompany.appserviceorder.model.enums.TipoSetorEnum;

/**
 *
 * @author GabrielBaca
 */
public class TecnicoDTO {

    private String nome;
    private String email;
    private String telefone;
    private String matricula;
    private TipoSetorEnum setor;

    public TecnicoDTO(String nome, String email, String telefone, String matricula, TipoSetorEnum setor) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public TipoSetorEnum getSetor() {
        return setor;
    }
}
