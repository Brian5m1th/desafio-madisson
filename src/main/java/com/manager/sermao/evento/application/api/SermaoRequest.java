package com.manager.sermao.evento.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SermaoRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    private String tema;
    @NotNull
    private LocalDateTime data;
    @NotBlank
    private String local;
    @NotBlank
    private String igreja;
    private String descricao;

}
