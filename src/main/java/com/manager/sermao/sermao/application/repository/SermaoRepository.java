package com.manager.sermao.sermao.application.repository;

import com.manager.sermao.sermao.domain.Sermao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SermaoRepository {
    void salva(Sermao sermao);
    List<Sermao> buscaTodosSermoes();
    Sermao buscaSermaoPorId(UUID id);
    void deletaSermaoPorId(UUID id);
    List<Sermao> buscaSermoesFiltrados(String igreja, String tema, LocalDateTime data);
}
