package com.ciandt.totalshakepagamentos.repository;

import com.ciandt.totalshakepagamentos.enums.Status;
import com.ciandt.totalshakepagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    boolean existsByIdAndStatus(Long id, Status status);
}
