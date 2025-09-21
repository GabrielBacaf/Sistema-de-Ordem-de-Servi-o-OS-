/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.Cliente;
import com.mycompany.appserviceorder.util.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class ClienteService {

    public void salvarCliente(Cliente cliente) {
        try (Connection conexao = Database.getConnection()) {
            conexao.setAutoCommit(false);

            int idPessoa = inserirPessoa(cliente, conexao);
            cliente.setId(idPessoa);

            inserirClienteEspecifico(cliente, conexao);

            conexao.commit();
            System.out.println("Cliente salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.email, p.telefone, c.cpf "
                   + "FROM pessoa p JOIN cliente c ON p.id = c.id";

        try (Connection conexao = Database.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clientes.add(construirClienteDoResultSet(rs));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        String sql = "SELECT p.id, p.nome, p.email, p.telefone, c.cpf "
                   + "FROM pessoa p JOIN cliente c ON p.id = c.id WHERE c.cpf = ?";

        try (Connection conexao = Database.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return construirClienteDoResultSet(rs);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return null;
    }

    public void atualizarCliente(Cliente cliente) {
        try (Connection conexao = Database.getConnection()) {
            conexao.setAutoCommit(false);

            atualizarPessoa(cliente, conexao);
            atualizarClienteEspecifico(cliente, conexao);

            conexao.commit();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void removerClientePorCpf(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (Connection conexao = Database.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    private int inserirPessoa(Cliente cliente, Connection conexao) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, email, telefone, tipo_usuario, tipo_setor) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getTipo().name());
            stmt.setString(5, cliente.getTipoSetor().name());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        throw new SQLException("Falha ao inserir pessoa.");
    }

    private void inserirClienteEspecifico(Cliente cliente, Connection conexao) throws SQLException {
        String sql = "INSERT INTO cliente (id, cpf) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getCpf());
            stmt.executeUpdate();
        }
    }

    private void atualizarPessoa(Cliente cliente, Connection conexao) throws SQLException {
        String sql = "UPDATE pessoa SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        }
    }

    private void atualizarClienteEspecifico(Cliente cliente, Connection conexao) throws SQLException {
        String sql = "UPDATE cliente SET cpf = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCpf());
            stmt.setInt(2, cliente.getId());
            stmt.executeUpdate();
        }
    }

    private Cliente construirClienteDoResultSet(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(
            rs.getString("nome"),
            rs.getString("email"),
            rs.getString("telefone"),
            rs.getString("cpf")
        );
        cliente.setId(rs.getInt("id"));
        return cliente;
    }
}
