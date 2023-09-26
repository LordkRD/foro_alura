package com.alura.foro.foro_alura.domain.curso;

public record DatosListaCurso(String nombre, String categoria) {

    public DatosListaCurso(Curso curso){
        this(curso.getNombre(), curso.getCategoria());
    }

}
