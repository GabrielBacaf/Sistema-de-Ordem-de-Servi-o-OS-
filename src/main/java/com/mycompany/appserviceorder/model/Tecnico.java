/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.model;

import com.mycompany.appserviceorder.model.enums.TipoSetorEnum;
import com.mycompany.appserviceorder.model.enums.TipoUsuarioEnum;

/**
 *
 * @author GabrielBaca
 */
public class Tecnico extends Pessoa {

    private String matricula;

    public Tecnico(String nome, String email, String telefone, TipoSetorEnum setor, String matricula) {
        super(nome, email, telefone);
        setTipo(TipoUsuarioEnum.TECNICO);
        setTipoSetor(setor);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
