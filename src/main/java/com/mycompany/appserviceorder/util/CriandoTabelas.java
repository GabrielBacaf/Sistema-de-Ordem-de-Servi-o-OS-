/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GabrielBaca
 */
public class CriandoTabelas {

    public static void criarTabelas() {
        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS pessoa ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(255) NOT NULL,"
                    + "email VARCHAR(255),"
                    + "telefone VARCHAR(50),"
                    + "tipo_usuario VARCHAR(50),"
                    + "tipo_setor VARCHAR(50)"
                    + ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS cliente ("
                    + "id INT PRIMARY KEY,"
                    + "cpf VARCHAR(20) NOT NULL,"
                    + "FOREIGN KEY (id) REFERENCES pessoa(id) ON DELETE CASCADE"
                    + ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS tecnico ("
                    + "id INT PRIMARY KEY,"
                    + "matricula VARCHAR(50) NOT NULL,"
                    + "FOREIGN KEY (id) REFERENCES pessoa(id) ON DELETE CASCADE"
                    + ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS servico ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(255) NOT NULL,"
                    + "descricao VARCHAR(500),"
                    + "valor DOUBLE"
                    + ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS ordem_servico ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "descricao VARCHAR(500),"
                    + "cliente_id INT NOT NULL,"
                    + "tecnico_id INT NULL,"
                    + "status VARCHAR(50),"
                    + "data_abertura TIMESTAMP,"
                    + "data_fechamento TIMESTAMP,"
                    + "FOREIGN KEY (cliente_id) REFERENCES cliente(id),"
                    + "FOREIGN KEY (tecnico_id) REFERENCES tecnico(id)"
                    + ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS pagamento ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "ordem_servico_id INT NOT NULL,"
                    + "valor DOUBLE,"
                    + "tipo_pagamento VARCHAR(50),"
                    + "data TIMESTAMP,"
                    + "FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id)"
                    + ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS ordem_servico_servico ("
                    + "ordem_servico_id INT NOT NULL,"
                    + "servico_id INT NOT NULL,"
                    + "PRIMARY KEY (ordem_servico_id, servico_id),"
                    + "FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id),"
                    + "FOREIGN KEY (servico_id) REFERENCES servico(id)"
                    + ");");

            System.out.println("Tabelas criadas com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
