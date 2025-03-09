package com.manager.sermao.sermao.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller 
@RequestMapping("/v1/sermao")
public interface SermaoApi {
    @PostMapping("/novo-sermao")
    @ResponseStatus(HttpStatus.CREATED)
    SermaoResponse postSermao(@Valid @RequestBody SermaoRequest sermaoRequest);

    @GetMapping("/lista-sermao")
    @ResponseStatus(HttpStatus.OK)
    List<SermaoDetalhaResponse> getTodosSermoes();

}