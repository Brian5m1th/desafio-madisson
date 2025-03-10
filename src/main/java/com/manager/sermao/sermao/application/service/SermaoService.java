package com.manager.sermao.sermao.application.service;

import com.manager.sermao.sermao.application.api.SermaoDetalhaResponse;
import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.application.api.SermaoResponse;

import java.util.List;

public interface SermaoService {
    SermaoResponse criaSermao(SermaoRequest sermaoRequest);

    List<SermaoDetalhaResponse> buscaTodosSermoes();
}

