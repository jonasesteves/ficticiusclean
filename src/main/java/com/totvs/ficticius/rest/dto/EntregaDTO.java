package com.totvs.ficticius.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntregaDTO {

    @NotNull(message = "{campo.preco-combustivel.obrigatorio}")
    @PositiveOrZero(message = "{campo.preco-combustivel.negativo}")
    private BigDecimal precoCombustivel;

    @NotNull(message = "{campo.quilometragem-cidade.obrigatorio}")
    @PositiveOrZero(message = "{campo.quilometragem.negativo}")
    private BigDecimal kmCidade;

    @NotNull(message = "{campo.quilometragem-rodovia.obrigatorio}")
    @PositiveOrZero(message = "{campo.quilometragem.negativo}")
    private BigDecimal kmRodovia;
}
