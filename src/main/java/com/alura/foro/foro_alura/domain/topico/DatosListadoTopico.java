package com.alura.foro.foro_alura.domain.topico;

import com.alura.foro.foro_alura.domain.curso.DatosListaCurso;
import com.alura.foro.foro_alura.domain.usuario.DatosListaUsuario;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico statusTopico,
                                 DatosListaUsuario datosListaUsuario, DatosListaCurso datosListaCursos) {
    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                StatusTopico.valueOf(topico.getEstatusTopico().toString()), new DatosListaUsuario(topico.getAutor()),
                new DatosListaCurso(topico.getCurso()));

    }
}
