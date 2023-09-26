package com.alura.foro.foro_alura.domain.topico;

import com.alura.foro.foro_alura.domain.curso.Curso;
import com.alura.foro.foro_alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now() ;
	@Enumerated(EnumType.STRING)
	private StatusTopico estatusTopico = StatusTopico.NO_RESPONDIDO;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private Usuario autor;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="curso_id")
	private Curso curso;

	public Topico(DatosRegistroTopico datosRegistroTopico ) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
		this.autor = new Usuario(datosRegistroTopico.datosUsuario());
		this.curso= new Curso(datosRegistroTopico.datosCurso());

	}

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if (datosActualizarTopico.titulo() != null || datosActualizarTopico.mensaje() != null) {
			this.titulo = datosActualizarTopico.titulo();
			this.mensaje = datosActualizarTopico.mensaje();
		}
		if (datosActualizarTopico.datosUsuario() != null) {
			this.autor = new Usuario(datosActualizarTopico.datosUsuario());
		}
		if (datosActualizarTopico.datosCurso() != null) {
			this.curso = new Curso(datosActualizarTopico.datosCurso());
		}
	}

	public void cambioStatusTopico(String status) {
		//this.estatusTopico =StatusTopico.CERRADO;
		this.estatusTopico = StatusTopico.valueOf(StatusTopico.class, status);

	}
}
