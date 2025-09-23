/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.util;

/**
 *
 * @author GabrielBaca
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.tools.Server;

public class Database {

     private static final String URL = "jdbc:h2:tcp://localhost/appserviceorder";

    private static Server webServer;
    private static Server tcpServer;

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, "sa", "");
    }

    public static void startDatabase() {
        try {

            tcpServer = Server.createTcpServer(
                    "-tcp", "-tcpAllowOthers", "-tcpPort", "9092", "-baseDir", "./"
            ).start();
            System.out.println("Servidor H2 TCP iniciado e escutando na porta 9092.");

            System.out.println("Servidor H2 TCP iniciado e escutando na porta 9092.");

            webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println("Console H2 Web disponível em: " + webServer.getURL());

        } catch (SQLException e) {
            System.err.println("Erro ao iniciar os servidores do H2: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void stopDatabase() {
        try {
            if (tcpServer != null && tcpServer.isRunning(false)) {
                tcpServer.stop();
                System.out.println("Servidor H2 TCP finalizado.");
            }
            if (webServer != null && webServer.isRunning(false)) {
                webServer.stop();
                System.out.println("Console H2 Web finalizado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao parar os servidores do H2: " + e.getMessage());
        }
    }

}
