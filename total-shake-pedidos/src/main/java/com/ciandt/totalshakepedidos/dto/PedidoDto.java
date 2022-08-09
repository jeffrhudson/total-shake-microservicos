package com.ciandt.totalshakepedidos.dto;

import com.ciandt.totalshakepedidos.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private Long id;
    private LocalDateTime dataHora;
    private Status status;
    List<ItemPedidoDto> itens;
}
