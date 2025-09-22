/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.controller;

import com.mycompany.appserviceorder.dto.OrdemServicoDTO;
import com.mycompany.appserviceorder.model.Cliente;
import com.mycompany.appserviceorder.model.OrdemServico;
import com.mycompany.appserviceorder.service.OrdemService;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class OrdemServicoController {

    private final OrdemService ordemService;

    public OrdemServicoController() {
        this.ordemService = new OrdemService();
    }

    public void cadastrarOrdem(OrdemServicoDTO dto) {
        OrdemServico ordem;
        ordem = new OrdemServico(
                dto.getDescricao(),
                dto.getClienteId(), 
                dto.getTecnicoId(), 
                dto.getServicoId(),
                dto.getPagamentoId(),
                null, 
                null, 
                null 
        );
        ordemService.salvarOrdem(ordem);
    }

    public List<OrdemServico> listarOrdens() {
        return ordemService.listarOrdens();
    }
//
//    public void atualizarOrdem(OrdemServicoDTO dto, int id) {
//        OrdemServico ordem = new OrdemServico(
//                dto.getDescricao(),
//                new Cliente(dto.getClienteId()),
//                new Tecnico(dto.getTecnicoId()),
//                dto.getServicoId(),
//                dto.getPagamentoId(),
//                dto.getStatus(),
//                dto.getDataAbertura(),
//                dto.getDataFechamento()
//        );
//        ordem.setId(id);
//        ordemService.atualizarOrdem(ordem);
//    };
}
