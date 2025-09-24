/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.Servico;
import com.mycompany.appserviceorder.util.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gabrielferreira
 */
public class ServicoService {

    // Salva um novo serviço e o associa a uma ordem de serviço
    public void salvarServico(Servico servico, int ordemId) {
        String sqlServico = "INSERT INTO servico (nome, descricao, valor) VALUES (?, ?, ?)";
        String sqlLink = "INSERT INTO ordem_servico_servico (ordem_servico_id, servico_id) VALUES (?, ?)";

        try (Connection conexao = Database.getConnection()) {
            conexao.setAutoCommit(false); // Inicia transação

            // 1. Insere o serviço na tabela 'servico'
            try (PreparedStatement stmtServico = conexao.prepareStatement(sqlServico, Statement.RETURN_GENERATED_KEYS)) {
                stmtServico.setString(1, servico.getNome());
                stmtServico.setString(2, servico.getDescricao());
                stmtServico.setDouble(3, servico.getValor());
                stmtServico.executeUpdate();

                // Recupera o ID do serviço que acabou de ser criado
                try (ResultSet rs = stmtServico.getGeneratedKeys()) {
                    if (rs.next()) {
                        servico.setId(rs.getInt(1));
                    }
                }
            }

            // 2. Insere a relação na tabela 'ordem_servico_servico'
            try (PreparedStatement stmtLink = conexao.prepareStatement(sqlLink)) {
                stmtLink.setInt(1, ordemId);
                stmtLink.setInt(2, servico.getId());
                stmtLink.executeUpdate();
            }

            conexao.commit(); // Confirma a transação
            System.out.println("Serviço salvo e vinculado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar serviço: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
