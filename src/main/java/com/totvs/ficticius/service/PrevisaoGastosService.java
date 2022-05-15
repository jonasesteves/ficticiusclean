package com.totvs.ficticius.service;

import com.totvs.ficticius.entity.Veiculo;
import com.totvs.ficticius.rest.dto.EntregaDTO;
import com.totvs.ficticius.rest.dto.PrevisaoGastosDTO;

import java.math.BigDecimal;
import java.util.List;

public interface PrevisaoGastosService {

    List<PrevisaoGastosDTO> calcular(EntregaDTO entregaDTO);
}
