package com.mycompany.appserviceorder.model;

import com.mycompany.appserviceorder.model.enums.TipoSetorEnum;
import com.mycompany.appserviceorder.model.enums.TipoUsuarioEnum;

/**
 *
 * @author GabrielBaca
 */
public abstract class Pessoa {
    
    private int id;  
    private String nome;
    private String email;
    private String telefone;
    private TipoUsuarioEnum tipo;
    private TipoSetorEnum tipoSetor;

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public TipoSetorEnum getTipoSetor() {
        return tipoSetor;
    }

    public void setTipoSetor(TipoSetorEnum tipoSetor) {
        this.tipoSetor = tipoSetor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuarioEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuarioEnum tipo) {
        this.tipo = tipo;
    }
}
