package com.totvs.ficticius.service;

import com.totvs.ficticius.entity.Veiculo;

import java.util.List;

public interface VeiculoService {

    Veiculo findById(Integer id);

    Veiculo save(Veiculo veiculo);

    void delete(Integer id);

    void update(Integer id, Veiculo veiculo);

    List<Veiculo> find(Veiculo veiculo);
}
