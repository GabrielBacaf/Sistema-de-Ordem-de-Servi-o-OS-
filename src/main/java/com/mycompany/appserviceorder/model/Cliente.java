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
public class Cliente extends Pessoa {

    private String cpf;
    
    public Cliente(){
        
    }

    public Cliente(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);
        setTipo(TipoUsuarioEnum.CLIENTE);
        setTipoSetor(TipoSetorEnum.NAO_APLICA);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
