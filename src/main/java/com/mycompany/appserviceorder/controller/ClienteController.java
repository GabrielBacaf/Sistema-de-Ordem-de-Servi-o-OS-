/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.controller;

import com.mycompany.appserviceorder.dto.ClienteDTO;
import com.mycompany.appserviceorder.model.Cliente;
import com.mycompany.appserviceorder.service.ClienteService;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController() {
        this.clienteService = new ClienteService();
    }

    public void cadastrarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente(dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getCpf());
        clienteService.salvarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    public Cliente buscarCliente(String cpf) {
        return clienteService.buscarClientePorCpf(cpf);
    }

    public void excluirCliente(String cpf) {
        clienteService.removerClientePorCpf(cpf);
    }
}
