package com.manager.sermao.evento.application.service;

import com.manager.sermao.evento.application.api.SermaoRequest;
import com.manager.sermao.evento.application.api.SermaoResponse;
import com.manager.sermao.evento.application.repository.SermaoRepository;
import com.manager.sermao.evento.domain.Sermao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SermaoApplicationService implements SermaoService {
    private final SermaoRepository sermaoRepository;

    @Override
    public SermaoResponse criaSermao(SermaoRequest sermaoRequest) {
        log.info("[start] SermaoApplicationService - criaSermao");
        Sermao sermao = new Sermao(sermaoRequest);
        log.info(sermao.toString());
        sermaoRepository.salva(sermao);
        log.info("[finish] SermaoApplicationService - criaSermao");
        return new SermaoResponse(sermao.getId());
    }
}
