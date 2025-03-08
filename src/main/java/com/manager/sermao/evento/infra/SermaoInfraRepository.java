package com.manager.sermao.evento.infra;

import com.manager.sermao.evento.application.repository.SermaoRepository;
import com.manager.sermao.evento.domain.Sermao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
