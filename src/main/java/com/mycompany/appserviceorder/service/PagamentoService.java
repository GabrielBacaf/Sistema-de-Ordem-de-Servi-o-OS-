/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.Pagamento;
import com.mycompany.appserviceorder.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author gabrielferreira
 */
public class PagamentoService {

    public void salvarPagamento(Pagamento pagamento, int ordemId) {
        String sql = "INSERT INTO pagamento (ordem_servico_id, valor, tipo_pagamento, data) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, ordemId);
            stmt.setDouble(2, pagamento.getValor());
            stmt.setString(3, pagamento.getTipoPagamento().name());
            stmt.setTimestamp(4, new Timestamp(pagamento.getData().getTime()));

            stmt.executeUpdate();
            System.out.println("Pagamento salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar pagamento: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
