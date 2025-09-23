/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.model;

import com.mycompany.appserviceorder.model.enums.StatusOrdemEnum;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class OrdemServico {

    private int id;
    private String descricao;
    private Cliente cliente;
    private Tecnico tecnico;
    private Servico servico;
    private Pagamento pagamento;
    private StatusOrdemEnum status;
    private Date dataAbertura;
    private Date dataFechamento;

    public OrdemServico(String descricao, Cliente cliente, Tecnico tecnico, Servico servico, Pagamento pagamento, StatusOrdemEnum status, Date dataAbertura, Date dataFechamento) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.servico = servico;
        this.pagamento = pagamento;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }
    

    public OrdemServico(String descricao, Cliente cliente) {
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public StatusOrdemEnum getStatus() {
        return status;
    }

    public void setStatus(StatusOrdemEnum status) {
        this.status = status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

}
