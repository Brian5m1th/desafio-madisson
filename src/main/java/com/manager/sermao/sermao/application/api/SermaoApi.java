package com.manager.sermao.sermao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;

@Controller 
@RequestMapping("/v1/sermao")
public interface SermaoApi {
    @PostMapping("/novo-sermao")
    @ResponseStatus(HttpStatus.CREATED)
    SermaoResponse postSermao(@Valid @RequestBody SermaoRequest sermaoRequest);
}
