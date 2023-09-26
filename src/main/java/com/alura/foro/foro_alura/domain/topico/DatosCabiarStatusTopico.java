package com.alura.foro.foro_alura.domain.topico;

public record DatosCabiarStatusTopico(StatusTopico statusTopico) {

    public DatosCabiarStatusTopico(Topico topico){
        this(topico.getEstatusTopico());
    }


}
