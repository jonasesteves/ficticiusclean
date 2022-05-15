package com.totvs.ficticius.rest.controller;

import com.totvs.ficticius.entity.Veiculo;
import com.totvs.ficticius.service.VeiculoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@Api("Api de veículos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("{id}")
    @ApiOperation("Obtém os detalhes de um veículo.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Veículo encontrado."),
            @ApiResponse(code = 404, message = "Não há veículo cadastrado com o ID informado.")
    })
    public Veiculo getVeiculoById(@PathVariable @ApiParam("Id do veículo") Integer id) {
        return veiculoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastra um veículo no sistema.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Veículo cadastrado com sucesso."),
            @ApiResponse(code = 400, message = "Dados informados para o cadastro são inválidos.")
    })
    public Veiculo save(@RequestBody @Valid Veiculo veiculo) {
        return veiculoService.save(veiculo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Exclui um veículo do sistema.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Veículo excluído com sucesso."),
            @ApiResponse(code = 400, message = "Não há veículo cadastrado com o ID informado.")
    })
    public void delete(@PathVariable @ApiParam("Id do veículo") Integer id) {
        veiculoService.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Altera os dados de um veículo cadastrado.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Veículo alterado com sucesso."),
            @ApiResponse(code = 400, message = "Não há veículo cadastrado com o ID informado.")
    })
    public void update(@PathVariable @ApiParam("Id do veículo") Integer id, @RequestBody @Valid Veiculo veiculo) {
        veiculoService.update(id, veiculo);
    }

    @GetMapping
    @ApiOperation("Busca os veículos com as características informadas.")
    @ApiResponses({@ApiResponse(code = 200, message = "Lista de veículo(s) encontrado(s).")})
    public List<Veiculo> find(Veiculo veiculo) {
        return veiculoService.find(veiculo);
    }

}
