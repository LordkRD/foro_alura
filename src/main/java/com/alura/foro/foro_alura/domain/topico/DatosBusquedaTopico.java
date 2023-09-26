package com.alura.foro.foro_alura.domain.topico;


import com.alura.foro.foro_alura.domain.curso.DatosCurso;
import com.alura.foro.foro_alura.domain.curso.DatosListaCurso;
import com.alura.foro.foro_alura.domain.usuario.DatosListaUsuario;
import com.alura.foro.foro_alura.domain.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosBusquedaTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion,
                                  StatusTopico statusTopico, DatosListaUsuario datosListaUsuario, DatosListaCurso datosListaCurso) {

    public DatosBusquedaTopico(Topico topico){

        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstatusTopico(),
                new DatosListaUsuario(topico.getAutor()),new DatosListaCurso(topico.getCurso()));
    }

}
