package com.alura.foro.foro_alura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class Prueva {

    @GetMapping
    public String prueva1(){
        return  "hola";
    }
}
