package com.manager.sermao.sermao.application.service;

import com.manager.sermao.sermao.application.api.SermaoDetalhaResponse;
import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.application.api.SermaoResponse;
import java.util.List;
import java.util.UUID;

public interface SermaoService {
    SermaoResponse criaSermao(SermaoRequest sermaoRequest);
    List<SermaoDetalhaResponse> buscaTodosSermoes();
    SermaoDetalhaResponse buscaSermaoPorId(UUID id);
    void deletaSermaoPorId(UUID id);
    void substituiSermaoPorId(UUID id, SermaoRequest sermaoRequest);

    List<SermaoDetalhaResponse> buscaSermoesFiltrados(String igreja, String tema, String data);
}

