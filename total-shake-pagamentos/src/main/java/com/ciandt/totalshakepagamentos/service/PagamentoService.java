package com.ciandt.totalshakepagamentos.service;

import com.ciandt.totalshakepagamentos.model.Pagamento;

import java.util.List;

public interface PagamentoService {
    public Pagamento salvarPagamento(Pagamento pagamento);
    public void atualizarPagamento(Pagamento pagamento);
    public void excluirPagamento(Long id);
    public Pagamento consultarPagamento(Long id);
    public List<Pagamento> listarTodosPagamentos();
}
