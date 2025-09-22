/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.OrdemServico;
import com.mycompany.appserviceorder.model.enums.StatusOrdemEnum;
import com.mycompany.appserviceorder.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class OrdemService {

    public void salvarOrdem(OrdemServico ordem) {
        String sql = "INSERT INTO ordem_servico (descricao, cliente_id, tecnico_id, status, data_abertura, data_fechamento) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, ordem.getDescricao());
            stmt.setObject(2, ordem.getCliente() != null ? ordem.getCliente().getId() : null, java.sql.Types.INTEGER);
            stmt.setObject(3, ordem.getTecnico() != null ? ordem.getTecnico().getId() : null, java.sql.Types.INTEGER);
            stmt.setString(4, StatusOrdemEnum.SOLICITADA.getDescricao());
            stmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            stmt.setObject(6, ordem.getDataFechamento() != null ? new java.sql.Date(ordem.getDataFechamento().getTime()) : null, java.sql.Types.DATE);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ordem.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao salvar ordem: " + e.getMessage());
        }
    }

    // --- LISTAR ---
    public List<OrdemServico> listarOrdens() {
        List<OrdemServico> ordens = new ArrayList<>();
        String sql = "SELECT id, descricao, cliente_id, tecnico_id, status, data_abertura, data_fechamento FROM ordem_servico";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ordens.add(construirOrdemDoResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar ordens: " + e.getMessage());
        }
        return ordens;
    }

    // --- ATUALIZAR ---
    public void atualizarOrdem(OrdemServico ordem) {
        String sql = "UPDATE ordem_servico SET descricao = ?, cliente_id = ?, tecnico_id = ?, status = ?, data_abertura = ?, data_fechamento = ? WHERE id = ?";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ordem.getDescricao());
            stmt.setObject(2, ordem.getClienteId() != null ? ordem.getCliente().getId() : null, java.sql.Types.INTEGER);
            stmt.setObject(3, ordem.getTecnico() != null ? ordem.getTecnico().getId() : null, java.sql.Types.INTEGER);
            stmt.setObject(4, ordem.getStatus() != null ? ordem.getStatus().name() : null, java.sql.Types.VARCHAR);
            stmt.setObject(5, ordem.getDataAbertura() != null ? new java.sql.Date(ordem.getDataAbertura().getTime()) : null, java.sql.Types.DATE);
            stmt.setObject(6, ordem.getDataFechamento() != null ? new java.sql.Date(ordem.getDataFechamento().getTime()) : null, java.sql.Types.DATE);
            stmt.setInt(7, ordem.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar ordem: " + e.getMessage());
        }
    }

    // --- CONSTRUTOR AUXILIAR ---
    private OrdemServico construirOrdemDoResultSet(ResultSet rs) throws SQLException {
        OrdemServico ordem = new OrdemServico(
                rs.getString("descricao"),
                null, // depois você carrega Cliente pelo id se precisar
                null, // idem para Técnico
                null, // serviços ficam para outra tabela
                null, // pagamentos idem
                rs.getString("status") != null ? StatusOrdemEnum.valueOf(rs.getString("status")) : null,
                rs.getDate("data_abertura"),
                rs.getDate("data_fechamento")
        );
        ordem.setId(rs.getInt("id"));
        return ordem;
    }
}
