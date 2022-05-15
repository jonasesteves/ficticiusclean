package com.totvs.ficticius.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "{campo.veiculo.nome.obrigatorio}")
    @NotEmpty(message = "{campo.veiculo.nome.obrigatorio}")
    @Column(length = 100)
    private String nome;

    @NotNull(message = "{campo.veiculo.marca.obrigatorio}")
    @NotEmpty(message = "{campo.veiculo.marca.obrigatorio}")
    @Column(length = 100)
    private String marca;

    @NotNull(message = "{campo.veiculo.modelo.obrigatorio}")
    @NotEmpty(message = "{campo.veiculo.modelo.obrigatorio}")
    @Column(length = 100)
    private String modelo;

    @NotNull(message = "{campo.veiculo.data-fabricacao.obrigatorio}")
    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;

    @NotNull(message = "{campo.veiculo.consumo-medio.obrigatorio}")
    @PositiveOrZero(message = "{campo.veiculo.consumo-medio.negativo}")
    @Column(name = "consumo_cidade", precision = 5, length = 3)
    private BigDecimal consumoCidade;

    @NotNull(message = "{campo.veiculo.consumo-medio.obrigatorio}")
    @PositiveOrZero(message = "{campo.veiculo.consumo-medio.negativo}")
    @Column(name = "consumo_rodovia", precision = 5, length = 3)
    private BigDecimal consumoRodovia;
}
