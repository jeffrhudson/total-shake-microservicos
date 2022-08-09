package com.ciandt.totalshakepagamentos.controller;

import com.ciandt.totalshakepagamentos.dto.PagamentoDto;
import com.ciandt.totalshakepagamentos.model.Pagamento;
import com.ciandt.totalshakepagamentos.service.PagamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pagamentos")
@AllArgsConstructor
public class PagamentoController {

    private final PagamentoService pagamentoService;

    private final ObjectMapper mapper;


    @PostMapping
    public ResponseEntity salvarPagamento(@RequestBody @Valid PagamentoDto pagamentoDto){
        var novoPagamento = mapper.convertValue(pagamentoDto, Pagamento.class);
        novoPagamento = pagamentoService.salvarPagamento(novoPagamento);
        final var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoPagamento.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity atualizarPagamento(@RequestBody @Valid PagamentoDto pagamentoDto){
        final var pagamento = mapper.convertValue(pagamentoDto, Pagamento.class);
        pagamentoService.atualizarPagamento(pagamento);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerPagamento(@PathVariable Long id){
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> consultarPagamento(@PathVariable Long id){
        final var pagamento = pagamentoService.consultarPagamento(id);
        return ResponseEntity.ok(mapper.convertValue(pagamento, PagamentoDto.class));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDto>> listarTodosPagamentos(){
        final var pagamentos = pagamentoService.listarTodosPagamentos();
        return ResponseEntity.ok(pagamentos.stream()
                                            .map(pagamento -> mapper.convertValue(pagamento, PagamentoDto.class))
                                            .toList());
    }
}
