package com.alura.foro.foro_alura.domain.respuesta;

import com.alura.foro.foro_alura.domain.topico.Topico;
import com.alura.foro.foro_alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String fechaCreacion;
    private boolean solucion;
    @ManyToOne
    private Usuario usuarioId;
    @ManyToOne
    private Topico topicoId;
}
