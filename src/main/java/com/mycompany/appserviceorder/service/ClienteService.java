/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.service;

import com.mycompany.appserviceorder.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente buscarPorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public void remover(String cpf) {
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }
}
