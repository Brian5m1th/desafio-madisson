package com.manager.sermao.sermao.infra;

import com.manager.sermao.sermao.domain.Sermao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SermaoSpringDataJpaRepository extends JpaRepository<Sermao, UUID> {
    List<Sermao> findByIgrejaOrTemaOrData(String igreja, String tema, LocalDateTime data);

}
