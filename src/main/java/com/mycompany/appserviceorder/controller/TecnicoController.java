/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.controller;

import com.mycompany.appserviceorder.dto.TecnicoDTO;
import com.mycompany.appserviceorder.model.Tecnico;
import com.mycompany.appserviceorder.service.TecnicoService;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController() {
        this.tecnicoService = new TecnicoService();
    }

    public void cadastrarTecnico(TecnicoDTO dto) {
        Tecnico tecnico = new Tecnico(dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getSetor(), dto.getMatricula()
        );
        tecnicoService.salvarTecnico(tecnico);
    }

    public List<Tecnico> listarTecnicos() {
        return tecnicoService.listarTecnicos();
    }

    public Tecnico buscarTecnicoPorMatricula(String matricula) {
        return tecnicoService.buscarTecnicoPorMatricula(matricula);
    }

    public void atualizarTecnico(TecnicoDTO dto, int id) {
        Tecnico tecnico = new Tecnico(dto.getNome(), dto.getEmail(), dto.getTelefone(), dto.getSetor(), dto.getMatricula()
        );
        tecnico.setId(id);
        tecnicoService.atualizarTecnico(tecnico);
    }

    public void excluirTecnico(String matricula) {
        tecnicoService.removerTecnicoPorMatricula(matricula);
    }
}
