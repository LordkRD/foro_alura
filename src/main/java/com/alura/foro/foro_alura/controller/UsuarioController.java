package com.alura.foro.foro_alura.controller;

import com.alura.foro.foro_alura.domain.usuario.DatosUsuario;
import com.alura.foro.foro_alura.domain.usuario.Usuario;
import com.alura.foro.foro_alura.infra.security.DatosJWTToken;
import com.alura.foro.foro_alura.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DatosUsuario datosUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosUsuario.nombre(),
                datosUsuario.contrasena());
        System.out.println(authToken.isAuthenticated());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
