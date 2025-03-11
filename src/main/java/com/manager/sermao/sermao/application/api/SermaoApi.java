package com.manager.sermao.sermao.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/v1/sermao")
public interface SermaoApi {
    @PostMapping("/novo-sermao")
    @ResponseStatus(HttpStatus.CREATED)
    SermaoResponse postSermao(@Valid @RequestBody SermaoRequest sermaoRequest);

    @GetMapping("/lista-sermoes")
    @ResponseStatus(HttpStatus.OK)
    List<SermaoDetalhaResponse> getTodosSermoes();

    @GetMapping(value = "/busca-sermao/{id}")
    @ResponseStatus(HttpStatus.OK)
    SermaoDetalhaResponse getBuscaIdSermoes(@PathVariable UUID id);

    @DeleteMapping(value = "/deleta-sermao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSermaoPorId(@PathVariable UUID id);

    @PutMapping(value = "/substitui-sermao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void substituiSermaoPorId(@PathVariable UUID id, @Valid @RequestBody SermaoRequest sermaoRequest);

    @GetMapping(value = "/filtra-sermao")
    @ResponseStatus(HttpStatus.OK)
    List<SermaoDetalhaResponse> getSermoesFiltrados(
            @RequestParam(required = false) String igreja,
            @RequestParam(required = false) String tema,
            @RequestParam(required = false) String data
    );
}