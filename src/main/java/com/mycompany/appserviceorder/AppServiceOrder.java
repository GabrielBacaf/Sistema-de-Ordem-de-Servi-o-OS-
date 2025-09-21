/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.appserviceorder;

import com.mycompany.appserviceorder.util.CriandoTabelas;
import com.mycompany.appserviceorder.util.Database;

/**
 *
 * @author GabrielBaca
 */
public class AppServiceOrder {

    public static void main(String[] args) {
        Database.startWebServer();
        CriandoTabelas.criarTabelas();
    }
}
