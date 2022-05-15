package com.totvs.ficticius.service.impl;

import com.totvs.ficticius.entity.Veiculo;
import com.totvs.ficticius.exception.RegraNegocioException;
import com.totvs.ficticius.repository.VeiculoRepository;
import com.totvs.ficticius.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public Veiculo findById(Integer id) {
        return veiculoRepository.findById(id).orElseThrow(
                () -> new RegraNegocioException("Veículo não encontrado.")
        );
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void delete(Integer id) {
        veiculoRepository.findById(id).map(veiculo -> {
            veiculoRepository.delete(veiculo);
            return veiculo;
        }).orElseThrow(
                () -> new RegraNegocioException("Veículo não encontrado.")
        );
    }

    @Override
    public void update(Integer id, Veiculo veiculo) {
        veiculoRepository.findById(id).map(veiculoExistente -> {
            veiculo.setId(veiculoExistente.getId());
            veiculoRepository.save(veiculo);
            return veiculoExistente;
        }).orElseThrow(() -> new RegraNegocioException("Veículo não encontrado."));
    }

    @Override
    public List<Veiculo> find(Veiculo veiculo) {
        ExampleMatcher matcher = ExampleMatcher
                .matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(veiculo, matcher);
        return veiculoRepository.findAll(example);
    }
}
