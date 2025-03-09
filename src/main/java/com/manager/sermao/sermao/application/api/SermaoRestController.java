package com.manager.sermao.sermao.application.api;

import com.manager.sermao.sermao.application.service.SermaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
