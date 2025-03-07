package com.manager.sermao.evento.domain;

import java.time.LocalDateTime;
import java.util.UUID;

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

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter 
@Entity
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

    public Sermao(UUID id, @NotBlank String titulo, @NotBlank String tema, @NotNull LocalDateTime data,
            @NotBlank String local, @NotBlank String igreja, String descricao, LocalDateTime dataHoraDoCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.tema = tema;
        this.data = data;
        this.local = local;
        this.igreja = igreja;
        this.descricao = descricao;
        this.dataHoraDoCadastro = dataHoraDoCadastro;
    }
}

