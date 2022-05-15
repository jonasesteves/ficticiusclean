package com.totvs.ficticius.rest;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String mensagem) {
        this.errors = Arrays.asList(mensagem);
    }

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }
}
