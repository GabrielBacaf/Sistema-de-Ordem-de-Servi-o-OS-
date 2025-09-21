/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.validation;

import com.mycompany.appserviceorder.dto.ClienteDTO;

/**
 *
 * @author GabrielBaca
 */
public class ValidadorCliente {

    public static void validar(ClienteDTO dto) throws IllegalArgumentException {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }

        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }
        if (!dto.getEmail().matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }

        if (dto.getTelefone() == null || dto.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone é obrigatório.");
        }
        if (!dto.getTelefone().matches("\\d{8,15}")) { 
            throw new IllegalArgumentException("Telefone deve conter apenas números (8 a 15 dígitos).");
        }

        if (dto.getCpf() == null || dto.getCpf().trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF é obrigatório.");
        }
        if (!dto.getCpf().matches("\\d{11}")) { 
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }
    }
}
