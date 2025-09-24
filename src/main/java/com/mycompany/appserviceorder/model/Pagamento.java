/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.model;

import com.mycompany.appserviceorder.model.enums.TipoPagamentoEnum;
import java.util.Date;

/**
 *
 * @author GabrielBaca
 */
public class Pagamento {

    private int id;
    private double valor;
    private Date data = new Date();
    private TipoPagamentoEnum tipoPagamento;
    
    public Pagamento(){
        
    }

    public Pagamento(double valor, TipoPagamentoEnum tipoPagamento) {
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamentoEnum tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
