/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.util;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GabrielBaca
 */
public class TesteH2 {

    public static void main(String[] args) throws SQLException {
        // Inicia o console web do H2 (acessível no navegador)
        Server webServer = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
        System.out.println("Console Web H2 iniciado: http://localhost:8082");

        try (Connection conn = Database.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS teste (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255))";
            stmt.execute(sql);
            System.out.println("Conexão H2 funcionando e tabela criada!");
        }
    }
}
