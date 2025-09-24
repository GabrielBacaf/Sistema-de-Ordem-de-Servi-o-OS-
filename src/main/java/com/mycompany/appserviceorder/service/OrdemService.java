/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.Cliente;
import com.mycompany.appserviceorder.model.OrdemServico;
import com.mycompany.appserviceorder.model.Tecnico;
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
            stmt.setObject(3, null, java.sql.Types.INTEGER);
            stmt.setString(4, StatusOrdemEnum.SOLICITADA.name());
            stmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
            stmt.setObject(6, null, java.sql.Types.TIMESTAMP);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ordem.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao salvar ordem: " + e.getMessage());
        }
    }

    public List<OrdemServico> listarOrdens() {
        List<OrdemServico> ordens = new ArrayList<>();

        // ANTES, a SQL provavelmente não tinha os JOINS para o técnico.
        // DEPOIS, a SQL completa e unificada fica assim:
        String sql = "SELECT "
                + "os.id, os.descricao, os.status, os.data_abertura, os.data_fechamento, "
                + "c.id as cliente_id, p_cliente.nome as cliente_nome, "
                + "t.id as tecnico_id, p_tecnico.nome as tecnico_nome "
                + "FROM ordem_servico os "
                + "LEFT JOIN cliente c ON os.cliente_id = c.id "
                + "LEFT JOIN pessoa p_cliente ON c.id = p_cliente.id "
                + "LEFT JOIN tecnico t ON os.tecnico_id = t.id "
                + "LEFT JOIN pessoa p_tecnico ON t.id = p_tecnico.id";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                ordens.add(construirOrdemDoResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar ordens: " + e.getMessage());
            e.printStackTrace();
        }
        return ordens;
    }

    public OrdemServico buscarPorId(int id) {
        String sql = "SELECT "
                + "os.id, os.descricao, os.status, os.data_abertura, os.data_fechamento, "
                + "c.id as cliente_id, p_cliente.nome as cliente_nome, "
                + "t.id as tecnico_id, p_tecnico.nome as tecnico_nome "
                + "FROM ordem_servico os "
                + "LEFT JOIN cliente c ON os.cliente_id = c.id "
                + "LEFT JOIN pessoa p_cliente ON c.id = p_cliente.id "
                + "LEFT JOIN tecnico t ON os.tecnico_id = t.id "
                + "LEFT JOIN pessoa p_tecnico ON t.id = p_tecnico.id "
                + "WHERE os.id = ?"; // ✅ A LINHA QUE FALTAVA

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return construirOrdemDoResultSet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar Ordem de Serviço por ID: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public void atualizarOrdem(OrdemServico ordem) {

        StringBuilder sql = new StringBuilder("UPDATE ordem_servico SET ");
        List<Object> params = new ArrayList<>();

        if (ordem.getDescricao() != null && !ordem.getDescricao().isEmpty()) {
            sql.append("descricao = ?, ");
            params.add(ordem.getDescricao());
        }
        if (ordem.getTecnico() != null) {
            sql.append("tecnico_id = ?, ");
            params.add(ordem.getTecnico().getId());
        }
        if (ordem.getStatus() != null) {
            sql.append("status = ?, ");
            params.add(ordem.getStatus().name());
        }
        if (ordem.getDataFechamento() != null) {
            sql.append("data_fechamento = ?, ");
            params.add(new java.sql.Timestamp(ordem.getDataFechamento().getTime()));
        }

        if (params.isEmpty()) {
            System.out.println("Nenhum campo para atualizar.");
            return;
        }
        sql.setLength(sql.length() - 2);

        sql.append(" WHERE id = ?");
        params.add(ordem.getId());

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            stmt.executeUpdate();
            System.out.println("Ordem de serviço atualizada com sucesso no banco.");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar ordem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private OrdemServico construirOrdemDoResultSet(ResultSet rs) throws SQLException {

        Cliente clienteDaOrdem = new Cliente();
        clienteDaOrdem.setId(rs.getInt("cliente_id"));
        clienteDaOrdem.setNome(rs.getString("cliente_nome"));

        Tecnico tecnicoDaOrdem = null;
        int tecnicoId = rs.getInt("tecnico_id");

        if (!rs.wasNull()) {
            tecnicoDaOrdem = new Tecnico();
            tecnicoDaOrdem.setId(tecnicoId);
            tecnicoDaOrdem.setNome(rs.getString("tecnico_nome"));
        }

        OrdemServico ordem = new OrdemServico(
                rs.getString("descricao"),
                clienteDaOrdem,
                tecnicoDaOrdem,
                null,
                null,
                rs.getString("status") != null ? StatusOrdemEnum.valueOf(rs.getString("status")) : null,
                rs.getTimestamp("data_abertura"),
                rs.getTimestamp("data_fechamento")
        );

        ordem.setId(rs.getInt("id"));
        return ordem;
    }
}
