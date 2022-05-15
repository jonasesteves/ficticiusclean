package com.totvs.ficticius.service.impl;

import com.totvs.ficticius.entity.Veiculo;
import com.totvs.ficticius.exception.RegraNegocioException;
import com.totvs.ficticius.repository.VeiculoRepository;
import com.totvs.ficticius.rest.dto.EntregaDTO;
import com.totvs.ficticius.rest.dto.PrevisaoGastosDTO;
import com.totvs.ficticius.service.PrevisaoGastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PrevisaoGastosServiceImpl implements PrevisaoGastosService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public List<PrevisaoGastosDTO> calcular(EntregaDTO entregaDTO) {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        if (veiculos.isEmpty()) {
            throw new RegraNegocioException("Nenhum veículo cadastrado.");
        }
        List<PrevisaoGastosDTO> previsoes = new ArrayList<>();
        for (Veiculo v : veiculos) {
            BigDecimal consumoMedioCidade = v.getConsumoCidade();
            BigDecimal consumoMedioRodovia = v.getConsumoRodovia();

            BigDecimal previsaoCidade = entregaDTO.getKmCidade().divide(consumoMedioCidade, 2, RoundingMode.HALF_EVEN);
            BigDecimal previsaoRodovia = entregaDTO.getKmRodovia().divide(consumoMedioRodovia, 2, RoundingMode.HALF_EVEN);

            BigDecimal qtCombustivelGasto = previsaoCidade.add(previsaoRodovia);
            BigDecimal vlrTotalGasto = qtCombustivelGasto.multiply(entregaDTO.getPrecoCombustivel()).setScale(2, RoundingMode.HALF_EVEN);

            PrevisaoGastosDTO p = new PrevisaoGastosDTO();
            p.setNome(v.getNome());
            p.setMarca(v.getMarca());
            p.setModelo(v.getModelo());
            p.setAno(v.getDataFabricacao().getYear());
            p.setQuantidadeCombustivelGasto(qtCombustivelGasto);
            p.setValorTotalGasto(vlrTotalGasto);

            previsoes.add(p);

        }
        Collections.sort(previsoes);
        return previsoes;
    }

}
