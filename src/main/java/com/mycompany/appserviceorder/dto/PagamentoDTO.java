/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.dto;

import com.mycompany.appserviceorder.model.enums.TipoPagamentoEnum;
import java.util.Date;

/**
 *
 * @author GabrielBaca
 */
public class PagamentoDTO {

    private double valor;
    private TipoPagamentoEnum tipoPagamento;
    private Date data;

    public PagamentoDTO(double valor, TipoPagamentoEnum tipoPagamento, Date data) {
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public Date getData() {
        return data;
    }
}
