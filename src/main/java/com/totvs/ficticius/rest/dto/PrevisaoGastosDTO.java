package com.totvs.ficticius.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrevisaoGastosDTO implements Comparable<PrevisaoGastosDTO>{

    private String nome;
    private String marca;
    private String modelo;
    private Integer ano;
    private BigDecimal quantidadeCombustivelGasto;
    private BigDecimal valorTotalGasto;

    @Override
    public int compareTo(PrevisaoGastosDTO o) {
        if (this.valorTotalGasto.compareTo(o.getValorTotalGasto()) == 1) {
            return 1;
        }
        if (o.getValorTotalGasto().compareTo(this.valorTotalGasto) == 1) {
            return -1;
        }
        return 0;
    }
}
