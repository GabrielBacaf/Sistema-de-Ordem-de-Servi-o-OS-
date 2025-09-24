/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appserviceorder.controller;

import com.mycompany.appserviceorder.dto.OrdemServicoDTO;
import com.mycompany.appserviceorder.model.OrdemServico;
import com.mycompany.appserviceorder.service.OrdemService;
import com.mycompany.appserviceorder.service.PagamentoService;
import com.mycompany.appserviceorder.service.ServicoService;
import java.util.List;

/**
 *
 * @author GabrielBaca
 */
public class OrdemServicoController {

    private final OrdemService ordemService = new OrdemService();
    private final ServicoService servicoService = new ServicoService();
    private final PagamentoService pagamentoService = new PagamentoService();

    public void cadastrarOrdem(OrdemServicoDTO dto) {
        OrdemServico ordem;
        ordem = new OrdemServico(
                dto.getDescricao(),
                dto.getClienteId()
        );
        ordemService.salvarOrdem(ordem);
    }

    public List<OrdemServico> listarOrdens() {
        return ordemService.listarOrdens();
    }

    public void atualizarOrdemCompleta(OrdemServico ordem) {

        ordemService.atualizarOrdem(ordem);

        if (ordem.getServico() != null) {
            servicoService.salvarServico(ordem.getServico(), ordem.getId());
        }

        if (ordem.getPagamento() != null) {
            pagamentoService.salvarPagamento(ordem.getPagamento(), ordem.getId());
        }
    }

}
