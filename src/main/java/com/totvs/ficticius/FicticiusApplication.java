package com.totvs.ficticius;

import com.totvs.ficticius.entity.Veiculo;
import com.totvs.ficticius.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FicticiusApplication extends SpringBootServletInitializer {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired VeiculoRepository veiculoRepository) {
        return args -> {
            Veiculo v1 = new Veiculo(
                    null,
                    "Corolla",
                    "Toyota",
                    "XEI",
                    LocalDate.of(2020, 5, 28),
                    BigDecimal.valueOf(10.55),
                    BigDecimal.valueOf(14.85)
            );

            Veiculo v2 = new Veiculo(
                    null,
                    "Fusion",
                    "Ford",
                    "Adventure",
                    LocalDate.of(2021, 5, 1),
                    BigDecimal.valueOf(19.8),
                    BigDecimal.valueOf(14.1)
            );

            Veiculo v3 = new Veiculo(
                    null,
                    "Uno",
                    "Fiat",
                    "Mille",
                    LocalDate.of(1993, 10, 8),
                    BigDecimal.valueOf(12.0),
                    BigDecimal.valueOf(13.4)
            );

            veiculoRepository.save(v1);
            veiculoRepository.save(v2);
            veiculoRepository.save(v3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(FicticiusApplication.class, args);
    }
}
