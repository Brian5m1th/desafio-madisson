package com.manager.sermao.evento.application.service;

import com.manager.sermao.evento.application.api.SermaoRequest;
import com.manager.sermao.evento.application.api.SermaoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SermaoApplicationService implements SermaoService {
    @Override
    public SermaoResponse criaSermao(SermaoRequest sermaoRequest) {
        log.info("[start] SermaoApplicationService - criaSermao");
        log.info("[finish] SermaoApplicationService - criaSermao");
        return null;
    }
}
