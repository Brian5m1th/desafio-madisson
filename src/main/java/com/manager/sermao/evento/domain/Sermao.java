package com.manager.sermao.evento.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.manager.sermao.evento.application.api.SermaoRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter 
@Entity
@ToString
public class Sermao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true , nullable = false)
    private UUID id;
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

    private LocalDateTime dataHoraDoCadastro;

    public Sermao(SermaoRequest sermaoRequest) {

        this.titulo = sermaoRequest.getTitulo();
        this.tema = sermaoRequest.getTema();
        this.data = sermaoRequest.getData();
        this.local = sermaoRequest.getLocal();
        this.igreja = sermaoRequest.getIgreja();
        this.descricao = sermaoRequest.getDescricao();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}

