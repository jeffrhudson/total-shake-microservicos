package com.ciandt.totalshakepagamentos.dto;

import com.ciandt.totalshakepagamentos.enums.FormaPagamento;
import com.ciandt.totalshakepagamentos.enums.Status;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class PagamentoDto {
    private Long id;

    @NotNull(message = "O valor não pode ser vazio")
    @DecimalMin(value = "0", message = "O valor deve ser maior ou igual a zero")
    private BigDecimal valor;

    @NotBlank(message = "O nome não pode ser vazio")
    @Length(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O número não pode ser vazio")
    @Length(max = 100, message = "O número deve ter no máximo 100 caracteres")
    private String numero;

    private String expiracao;

    @NotBlank(message = "O código não pode ser vazio")
    @Length(min = 3,max = 3, message = "O código deve ter no minimo e máximo 3 caracteres")
    private String codigo;

    @NotNull
    private Status status;

    private Long pedidoId;

    private FormaPagamento formaPagamento;
}
