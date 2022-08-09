package com.ciandt.totalshakepagamentos.service.impl;

import com.ciandt.totalshakepagamentos.enums.Status;
import com.ciandt.totalshakepagamentos.model.Pagamento;
import com.ciandt.totalshakepagamentos.repository.PagamentoRepository;
import com.ciandt.totalshakepagamentos.service.PagamentoService;
import com.ciandt.totalshakepagamentos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    private final PedidoService pedidoService;

    @Override
    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public void atualizarPagamento(Pagamento pagamento) {
        if (!isPago(pagamento.getId()) && Status.CONFIRMADO.equals(pagamento.getStatus())){
            pedidoService.atualizarStatus(pagamento.getPedidoId());
        }
        salvarPagamento(pagamento);
    }

    private boolean isPago(Long id){
        return pagamentoRepository.existsByIdAndStatus(id, Status.CONFIRMADO);
    }

    @Override
    public void excluirPagamento(Long id) {
        pagamentoRepository.deleteById(id);
    }

    @Override
    public Pagamento consultarPagamento(Long id) {
        return pagamentoRepository.findById(id).get();
    }

    @Override
    public List<Pagamento> listarTodosPagamentos() {
        return pagamentoRepository.findAll();
    }
}
