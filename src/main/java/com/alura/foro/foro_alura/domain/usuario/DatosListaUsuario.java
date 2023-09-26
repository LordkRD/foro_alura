package com.alura.foro.foro_alura.domain.usuario;

public record DatosListaUsuario(String nombre, String email) {

    public DatosListaUsuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getEmail());
    }

}
