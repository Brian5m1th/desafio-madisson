package com.manager.sermao;

import com.manager.sermao.sermao.application.api.SermaoRequest;
import com.manager.sermao.sermao.domain.Sermao;

import java.time.LocalDateTime;

public class DataHelper {

    public static SermaoRequest criaSermaoRequest() {
        return new SermaoRequest("titulo", "tema", LocalDateTime.now(), "local", "igreja", "descricao");
    }

    public static Sermao criaSermao() {
        return new Sermao(criaSermaoRequest());
    }
}
