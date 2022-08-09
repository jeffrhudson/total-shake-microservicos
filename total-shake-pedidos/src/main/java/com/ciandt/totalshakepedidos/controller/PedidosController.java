package com.ciandt.totalshakepedidos.controller;

import com.ciandt.totalshakepedidos.dto.PedidoDto;
import com.ciandt.totalshakepedidos.model.Pedido;
import com.ciandt.totalshakepedidos.service.PedidoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("pedidos")
public class PedidosController {

    private final PedidoService pedidoService;

    private final ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> getPedido(@PathVariable Long id){
        return ResponseEntity.ok(objectMapper.convertValue(pedidoService.getPedido(id),
                                                            PedidoDto.class));
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoDto>> listarPedidos(){
        return ResponseEntity.ok(pedidoService.getTodosPedidos()
                                                .stream()
                                                .map(pedido -> objectMapper.convertValue(pedido, PedidoDto.class))
                                                .toList());
    }

    @PostMapping
    public ResponseEntity cadastrarPedido(@Valid @RequestBody PedidoDto pedidoDto){
        var pedido = objectMapper.convertValue(pedidoDto, Pedido.class);
        pedido = pedidoService.cadastrarPedido(pedido);
        final var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                                        .path("/{id}")
                                                        .buildAndExpand(pedido.getId())
                                                        .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity alterarPedido(@Valid @RequestBody PedidoDto pedidoDto){
        final var pedido = objectMapper.convertValue(pedidoDto, Pedido.class);
        pedidoService.atualizarPedido(pedido);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removerPedido(@PathVariable Long id){
        pedidoService.removerPedido(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/atualizar-status")
    public ResponseEntity atualizarStatus(@PathVariable Long id){
        pedidoService.atualizarStatus(id);
        return ResponseEntity.ok().build();
    }
}
