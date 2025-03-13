package com.manager.sermao.sermao.application.service;

import com.manager.sermao.handler.APIException;
import com.manager.sermao.sermao.application.api.SermaoDetalhaResponse;
import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.application.api.SermaoResponse;
import com.manager.sermao.sermao.application.repository.SermaoRepository;
import com.manager.sermao.sermao.domain.Sermao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class SermaoApplicationService implements SermaoService {
    private final SermaoRepository sermaoRepository;


    @Override
    public SermaoResponse criaSermao(SermaoRequest sermaoRequest) {
        log.info("[start] SermaoApplicationService - criaSermao");
        boolean exists = sermaoRepository.existsByTemaAndIgrejaAndData(
                sermaoRequest.getTema(), sermaoRequest.getIgreja(), sermaoRequest.getData());

        if (exists) {
            throw APIException.build(HttpStatus.CONFLICT, "Um evento com o mesmo tema, igreja e data já existe.");
        }
        Sermao sermao = new Sermao(sermaoRequest);
        sermaoRepository.salva(sermao);
        log.info("[finish] SermaoApplicationService - criaSermao");
        return new SermaoResponse(sermao.getId());
    }

    @Override
    public List<SermaoDetalhaResponse> buscaTodosSermoes() {
        log.info("[start] SermaoApplicationService - buscaTodosSermoes");
        List<Sermao> sermaoList = sermaoRepository.buscaTodosSermoes();
        log.info("[finish] SermaoApplicationService - buscaTodosSermoes");
        return SermaoDetalhaResponse.converte(sermaoList);
    }

    @Override
    public SermaoDetalhaResponse buscaSermaoPorId(UUID id) {
        log.info("[start] SermaoApplicationService - buscaSermaoPorId");
        Sermao sermao = sermaoRepository.buscaSermaoPorId(id);
        log.info("[finish] SermaoApplicationService - buscaSermaoPorId");
        return new SermaoDetalhaResponse(sermao);
    }

    @Override
    public void deletaSermaoPorId(UUID id) {
        log.info("[start] SermaoApplicationService - deletaSermaoPorId");
        sermaoRepository.buscaSermaoPorId(id);
        sermaoRepository.deletaSermaoPorId(id);
        log.info("[finish] SermaoApplicationService - deletaSermaoPorId");
    }

    @Override
    public void substituiSermaoPorId(UUID id, SermaoRequest sermaoRequest) {
        log.info("[start] SermaoApplicationService - substituiSermaoPorId");
        Sermao sermao = sermaoRepository.buscaSermaoPorId(id);
        sermao.substituiSermao(sermaoRequest);
        sermaoRepository.salva(sermao);
        log.info("[finish] SermaoApplicationService - substituiSermaoPorId");
    }

    @Override
    public List<SermaoDetalhaResponse> buscaSermoesFiltrados(String igreja, String tema, LocalDateTime data) {
        log.info("[start] SermaoInfraRepository - buscaSermoesFiltrados");
        List<Sermao> sermaoList = sermaoRepository.buscaSermoesFiltrados(igreja, tema, data);
        log.info("[finish] SermaoInfraRepository - buscaSermoesFiltrados");
        return SermaoDetalhaResponse.converte(sermaoList);
    }

}
