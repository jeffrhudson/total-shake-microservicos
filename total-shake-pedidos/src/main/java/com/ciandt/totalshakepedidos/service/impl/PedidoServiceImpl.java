package com.ciandt.totalshakepedidos.service.impl;

import com.ciandt.totalshakepedidos.enums.Status;
import com.ciandt.totalshakepedidos.model.Pedido;
import com.ciandt.totalshakepedidos.repository.PedidoRepository;
import com.ciandt.totalshakepedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido getPedido(Long id) {
        return pedidoRepository.findById(id).get();
    }

    @Override
    public List<Pedido> getTodosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido cadastrarPedido(Pedido pedidoCadastrar) {
        return pedidoRepository.save(pedidoCadastrar);
    }

    @Override
    public void removerPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public void atualizarPedido(Pedido pedidoAtualizar) {
        pedidoRepository.save(pedidoAtualizar);
    }

    @Override
    public void atualizarStatus(Long id) {
        final var pedido = getPedido(id);
        pedido.setStatus(Status.PAGO);
        pedidoRepository.save(pedido);
    }
}
