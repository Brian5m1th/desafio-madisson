package com.manager.sermao.sermao.application.api;

import com.manager.sermao.sermao.domain.Sermao;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class SermaoDetalhaResponse {

    private UUID id;
    private String titulo;
    private String tema;
    private LocalDateTime data;
    private String local;
    private String igreja;
    private String descricao;
    private LocalDateTime dataHoraDoCadastro;

    public static List<SermaoDetalhaResponse> converte(List<Sermao> sermaoList) {
        return sermaoList.stream()
                .map(SermaoDetalhaResponse::new)
                .collect(Collectors.toList());
    }

    public SermaoDetalhaResponse(Sermao sermao) {
        this.id = sermao.getId();
        this.titulo = sermao.getTitulo();
        this.tema = sermao.getTema();
        this.data = sermao.getData();
        this.local = sermao.getLocal();
        this.igreja = sermao.getIgreja();
        this.descricao = sermao.getDescricao();
        this.dataHoraDoCadastro = sermao.getDataHoraDoCadastro();
    }
}

