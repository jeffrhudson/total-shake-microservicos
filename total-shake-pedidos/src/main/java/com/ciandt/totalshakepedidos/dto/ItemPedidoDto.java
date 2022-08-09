package com.ciandt.totalshakepedidos.dto;

import lombok.Data;

@Data
public class ItemPedidoDto {
    private Long id;
    private Integer quantidade;
    private String descricao;
}
