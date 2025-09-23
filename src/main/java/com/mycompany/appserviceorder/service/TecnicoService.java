/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.Tecnico;
import com.mycompany.appserviceorder.model.enums.TipoSetorEnum;
import com.mycompany.appserviceorder.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class TecnicoService {

    public void salvarTecnico(Tecnico tecnico) {
        try (Connection conexao = Database.getConnection()) {
            conexao.setAutoCommit(false);

            int idPessoa = inserirPessoa(tecnico, conexao);
            tecnico.setId(idPessoa);

            inserirTecnicoEspecifico(tecnico, conexao);

            conexao.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar técnico: " + e.getMessage());
        }
    }

    public List<Tecnico> listarTecnicos() {
        List<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.email, p.telefone, t.matricula, p.tipo_setor "
                + "FROM pessoa p JOIN tecnico t ON p.id = t.id";
        

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tecnicos.add(construirTecnicoDoResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar técnicos: " + e.getMessage());
        }
        return tecnicos;
    }

    public Tecnico buscarTecnicoPorMatricula(String matricula) {
        String sql = "SELECT p.id, p.nome, p.email, p.telefone, t.matricula, p.tipo_setor "
                + "FROM pessoa p JOIN tecnico t ON p.id = t.id WHERE t.matricula = ?";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return construirTecnicoDoResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar técnico: " + e.getMessage());
        }
        return null;
    }

    public void atualizarTecnico(Tecnico tecnico) {
        try (Connection conexao = Database.getConnection()) {
            conexao.setAutoCommit(false);

            atualizarPessoa(tecnico, conexao);
            atualizarTecnicoEspecifico(tecnico, conexao);

            conexao.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar técnico: " + e.getMessage());
        }
    }

    public void removerTecnicoPorMatricula(String matricula) {
        String sql = "DELETE FROM tecnico WHERE matricula = ?";

        try (Connection conexao = Database.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Técnico removido com sucesso!");
            } else {
                System.out.println("Técnico não encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover técnico: " + e.getMessage());
        }
    }

    // --- MÉTODOS PRIVADOS AUXILIARES ---
    private int inserirPessoa(Tecnico tecnico, Connection conexao) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, email, telefone, tipo_usuario, tipo_setor) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getEmail());
            stmt.setString(3, tecnico.getTelefone());
            stmt.setString(4, tecnico.getTipo().name());
            stmt.setString(5, tecnico.getTipoSetor().name());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        throw new SQLException("Falha ao inserir pessoa.");
    }

    private void inserirTecnicoEspecifico(Tecnico tecnico, Connection conexao) throws SQLException {
        String sql = "INSERT INTO tecnico (id, matricula) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, tecnico.getId());
            stmt.setString(2, tecnico.getMatricula());
            stmt.executeUpdate();
        }
    }

    private void atualizarPessoa(Tecnico tecnico, Connection conexao) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, email = ?, telefone = ?, tipo_setor = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getEmail());
            stmt.setString(3, tecnico.getTelefone());
            stmt.setString(4, tecnico.getTipoSetor().name());
            stmt.setInt(5, tecnico.getId());
            stmt.executeUpdate();
        }
    }

    private void atualizarTecnicoEspecifico(Tecnico tecnico, Connection conexao) throws SQLException {
        String sql = "UPDATE tecnico SET matricula = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, tecnico.getMatricula());
            stmt.setInt(2, tecnico.getId());
            stmt.executeUpdate();
        }
    }

    private Tecnico construirTecnicoDoResultSet(ResultSet rs) throws SQLException {
        TipoSetorEnum tipoSetor = TipoSetorEnum.valueOf(rs.getString("tipo_setor"));
        Tecnico tecnico = new Tecnico(
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                tipoSetor,
                rs.getString("matricula")
        );
        tecnico.setId(rs.getInt("id"));
        return tecnico;
    }
}
