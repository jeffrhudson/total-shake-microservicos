package com.ciandt.totalshakepedidos.service;

import com.ciandt.totalshakepedidos.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido getPedido(Long id);
    List<Pedido> getTodosPedidos();
    Pedido cadastrarPedido(Pedido pedidoCadastrar);
    void removerPedido(Long id);
    void atualizarPedido(Pedido pedidoAtualizar);

    void atualizarStatus(Long id);
}
