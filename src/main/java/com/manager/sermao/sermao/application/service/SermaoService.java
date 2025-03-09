package com.manager.sermao.sermao.application.service;

import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.application.api.SermaoResponse;

public interface SermaoService {
    SermaoResponse criaSermao(SermaoRequest sermaoRequest);
}

