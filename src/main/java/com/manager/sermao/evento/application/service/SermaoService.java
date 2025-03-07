package com.manager.sermao.evento.application.service;

import com.manager.sermao.evento.application.api.SermaoRequest;
import com.manager.sermao.evento.application.api.SermaoResponse;

public interface SermaoService {
    SermaoResponse criaSermao(SermaoRequest sermaoRequest);
}

