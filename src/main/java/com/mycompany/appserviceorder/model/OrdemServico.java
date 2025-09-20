/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.model;

import com.mycompany.appserviceorder.model.enums.StatusOrdemEnum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class OrdemServico {

    private int id;
    private String descricao;
    private Cliente cliente;
    private Tecnico tecnico;
    private List<Servico> servicos;
    private List<Pagamento> pagamentos;
    private StatusOrdemEnum status;
    private Date dataAbertura;
    private Date dataFechamento;

    public OrdemServico(String descricao, Cliente cliente, Tecnico tecnico, List<Servico> servicos, List<Pagamento> pagamentos, StatusOrdemEnum status, Date dataAbertura, Date dataFechamento) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.servicos = servicos;
        this.pagamentos = pagamentos;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
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
