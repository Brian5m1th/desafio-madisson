package com.manager.sermao.sermao.application.repository;

import com.manager.sermao.sermao.domain.Sermao;

import java.util.List;

public interface SermaoRepository {
    void salva(Sermao sermao);
    List<Sermao> buscaTodosSermoes();
}
