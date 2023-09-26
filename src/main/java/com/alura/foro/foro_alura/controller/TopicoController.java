package com.alura.foro.foro_alura.controller;

import com.alura.foro.foro_alura.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosBusquedaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosBusquedaTopico datosBusquedaTopico = new DatosBusquedaTopico(topico);
        URI url = uriComponentsBuilder.path("topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosBusquedaTopico);

    }
    @GetMapping
    public List<DatosListadoTopico> listadoTopicos() {
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosBusquedaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosBusquedaTopico(topico);
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosBusquedaTopico(topico));
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity cambiarTopico(@PathVariable Long id, @RequestBody DatosCabiarStatusTopico datosCabiarStatusTopico) {
//        Topico topico = topicoRepository.getReferenceById(id);
//        if (datosCabiarStatusTopico.statusTopico().toString() != null){
//            topico.cambioStatusTopico(datosCabiarStatusTopico.statusTopico().toString());
//        }
//        topicoRepository.delete(topico);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id ) {
        Topico topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.noContent().build();
    }
}
