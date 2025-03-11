package com.manager.sermao.sermao.infra;

import com.manager.sermao.handler.APIException;
import com.manager.sermao.sermao.application.repository.SermaoRepository;
import com.manager.sermao.sermao.domain.Sermao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class SermaoInfraRepository implements SermaoRepository {
    private final SermaoSpringDataJpaRepository sermaoSpringDataJpaRepository;

    @Override
    public void salva(Sermao sermao) {
        log.info("[start] SermaoInfraRepository - salva");
        sermaoSpringDataJpaRepository.save(sermao);
        log.info("[finish] SermaoInfraRepository - salva");
    }

    @Override
    public List<Sermao> buscaTodosSermoes() {
        log.info("[start] SermaoInfraRepository - buscaTodosSermoes");
        List<Sermao> listaDeSermoes = sermaoSpringDataJpaRepository.findAll();
        log.info("[finish] SermaoInfraRepository - buscaTodosSermoes");
        return listaDeSermoes;
    }

    @Override
    public Sermao buscaSermaoPorId(UUID id) {
        log.info("[start] SermaoInfraRepository - buscaSermaoPorId");
        Sermao sermao = sermaoSpringDataJpaRepository.findById(id)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Sermão não encontrado"));
        log.info("[finish] SermaoInfraRepository - buscaSermaoPorId");
        return sermao;
    }

    @Override
    public void deletaSermaoPorId(UUID id) {
        log.info("[start] SermaoInfraRepository - buscaSermaoPorId");
        sermaoSpringDataJpaRepository.deleteById(id);
        log.info("[finish] SermaoInfraRepository - buscaSermaoPorId");
    }

    @Override
    public List<Sermao> buscaSermoesFiltrados(String igreja, String tema, LocalDateTime data) {
        log.info("[start] SermaoInfraRepository - buscaSermoesFiltrados");
        List<Sermao> sermaoList = sermaoSpringDataJpaRepository.findByIgrejaOrTemaOrData(igreja, tema, data);
        log.info("[finish] SermaoInfraRepository - buscaSermoesFiltrados");
        return sermaoList;
    }
}