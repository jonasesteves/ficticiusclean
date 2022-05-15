package com.totvs.ficticius.rest.controller;

import com.totvs.ficticius.rest.dto.EntregaDTO;
import com.totvs.ficticius.rest.dto.PrevisaoGastosDTO;
import com.totvs.ficticius.service.PrevisaoGastosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/previsao-gastos")
@Api("API de previsão de gastos.")
public class PrevisaoGastosController {

    @Autowired
    private PrevisaoGastosService previsaoGastosService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Obtém uma lista de veículos e seus respectivos gastos para a entrega.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Lista de veículos organizada do menor gasto ao maior gasto."),
            @ApiResponse(code = 400, message = "Dados informados para a consulta são inválidos.")
    })
    public List<PrevisaoGastosDTO> calcular(@RequestBody @Valid EntregaDTO entregaDTO) {
        return previsaoGastosService.calcular(entregaDTO);
    }
}
