/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.dto;

import com.mycompany.appserviceorder.model.Cliente;
import com.mycompany.appserviceorder.model.Pagamento;
import com.mycompany.appserviceorder.model.Servico;
import com.mycompany.appserviceorder.model.Tecnico;
import com.mycompany.appserviceorder.model.enums.StatusOrdemEnum;
import java.util.Date;

/**
 *
 * @author GabrielBaca
 */
public class OrdemServicoDTO {

    private String descricao;
    private int clienteId;
    private Tecnico tecnicoId;
    private Servico servicoId;
    private Pagamento pagamentoId;
    private StatusOrdemEnum status;
    private Date dataAbertura;
    private Date dataFechamento;

    public OrdemServicoDTO(String descricao, int clienteId, Tecnico tecnicoId,
            Servico servicoId, Pagamento pagamentoId,
            StatusOrdemEnum status, Date dataAbertura, Date dataFechamento) {
        this.descricao = descricao;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
        this.servicoId = servicoId;
        this.pagamentoId = pagamentoId;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusOrdemEnum getStatus() {
        return status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public Servico getServicoId() {
        return servicoId;
    }

    public void setServicoId(Servico servicoId) {
        this.servicoId = servicoId;
    }

    public Pagamento getPagamentoId() {
        return pagamentoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Tecnico getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Tecnico tecnicoId) {
        this.tecnicoId = tecnicoId;
    }
    
    

    public void setPagamentoId(Pagamento pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

}
