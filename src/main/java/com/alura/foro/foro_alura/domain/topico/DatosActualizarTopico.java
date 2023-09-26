package com.alura.foro.foro_alura.domain.topico;


import com.alura.foro.foro_alura.domain.curso.DatosCurso;
import com.alura.foro.foro_alura.domain.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        DatosUsuario datosUsuario,
        DatosCurso datosCurso) {
}
