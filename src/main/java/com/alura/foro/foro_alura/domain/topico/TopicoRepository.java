package com.alura.foro.foro_alura.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
