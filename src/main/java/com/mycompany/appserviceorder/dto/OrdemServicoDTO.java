/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.dto;

import com.mycompany.appserviceorder.model.enums.StatusOrdemEnum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class OrdemServicoDTO {

    private String descricao;
    private int clienteId;
    private int tecnicoId;
    private List<Integer> servicosIds;
    private List<Integer> pagamentosIds;
    private StatusOrdemEnum status;
    private Date dataAbertura;
    private Date dataFechamento;

    public OrdemServicoDTO(String descricao, int clienteId, int tecnicoId,
            List<Integer> servicosIds, List<Integer> pagamentosIds,
            StatusOrdemEnum status, Date dataAbertura, Date dataFechamento) {
        this.descricao = descricao;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
        this.servicosIds = servicosIds;
        this.pagamentosIds = pagamentosIds;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getTecnicoId() {
        return tecnicoId;
    }

    public List<Integer> getServicosIds() {
        return servicosIds;
    }

    public List<Integer> getPagamentosIds() {
        return pagamentosIds;
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
}
