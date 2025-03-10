package com.manager.sermao.sermao.application.service;

import com.manager.sermao.sermao.application.api.SermaoDetalhaResponse;
import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.application.api.SermaoResponse;
import com.manager.sermao.sermao.application.repository.SermaoRepository;
import com.manager.sermao.sermao.domain.Sermao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SermaoApplicationService implements SermaoService {
    private final SermaoRepository sermaoRepository;

    @Override
    public SermaoResponse criaSermao(SermaoRequest sermaoRequest) {
        log.info("[start] SermaoApplicationService - criaSermao");
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
}
