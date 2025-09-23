/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.appserviceorder;

import com.mycompany.appserviceorder.util.CriandoTabelas;
import com.mycompany.appserviceorder.util.Database;
import com.mycompany.appserviceorder.view.index;

/**
 *
 * @author GabrielBaca
 */
public class AppServiceOrder {

    public static void main(String[] args) {
        Database.startDatabase();
        CriandoTabelas.criarTabelas();
        java.awt.EventQueue.invokeLater(() -> {
            new index().setVisible(true);
        });
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Finalizando a aplicação...");
            Database.stopDatabase();

        }));
    }
}
