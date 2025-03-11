package com.manager.sermao.sermao.application.api;


import com.manager.sermao.sermao.application.service.SermaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SermaoRestController implements SermaoApi {
    private final SermaoService sermaoService;

    @Override
    public SermaoResponse postSermao(SermaoRequest sermaoRequest) {
        log.info("[start] SermaoRestController - postSermao");
        SermaoResponse sermaoCriado = sermaoService.criaSermao(sermaoRequest);
        log.info("[finish] SermaoRestController - postSermao");
        return sermaoCriado;
    }

    @Override
    public List<SermaoDetalhaResponse> getTodosSermoes() {
        log.info("[start] SermaoRestController - getTodosSermoes");
        List<SermaoDetalhaResponse> sermaoList = sermaoService.buscaTodosSermoes();
        log.info("[finish] SermaoRestController - getTodosSermoes");
        return sermaoList;
    }

    @Override
    public SermaoDetalhaResponse getBuscaIdSermoes(UUID id) {
        log.info("[start] SermaoRestController - getBuscaIdSermoes");
        SermaoDetalhaResponse response = sermaoService.buscaSermaoPorId(id);
        log.info("[finish] SermaoRestController - getBuscaIdSermoes");
        return response;

    }

    @Override
    public void deleteSermaoPorId(UUID id) {
        log.info("[start] SermaoRestController - deletaSermao");
        sermaoService.deletaSermaoPorId(id);
        log.info("[finish] SermaoRestController - deletaSermao");
    }

    @Override
    public void substituiSermaoPorId(UUID id, SermaoRequest sermaoRequest) {
        log.info("[start] SermaoRestController - substituiSermaoPorId");
        sermaoService.substituiSermaoPorId(id, sermaoRequest);
        log.info("[finish] SermaoRestController - substituiSermaoPorId");
    }

    @Override
    public List<SermaoDetalhaResponse> getSermoesFiltrados(String igreja, String tema, LocalDateTime data) {
        log.info("[start] SermaoRestController - getSermoesFiltrados");
        log.info("QueryParaments: igreja: {} tema: {} data: {}", igreja, tema, data);
        List<SermaoDetalhaResponse> sermaoList = sermaoService.buscaSermoesFiltrados(igreja, tema, data);
        log.info("[finish] SermaoRestController - getSermoesFiltrados");
        return sermaoList;
    }



}

