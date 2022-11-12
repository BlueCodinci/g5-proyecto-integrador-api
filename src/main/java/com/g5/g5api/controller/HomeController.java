package com.g5.g5api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return " <h1>Restaurante API Rest - Curso Proyecto Integrador - Grupo 5</h1>\n" +
                "                  <a href=\"swagger-ui/#/\">Ver Swagger UI</a>";
    }
}
