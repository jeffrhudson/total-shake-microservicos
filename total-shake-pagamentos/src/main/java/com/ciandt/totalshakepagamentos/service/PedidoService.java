package com.ciandt.totalshakepagamentos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ms-pedidos")
public interface PedidoService {

    @PutMapping(value = "pedidos/{id}/atualizar-status")
    void atualizarStatus(@PathVariable("id") Long pedidoId);
}
