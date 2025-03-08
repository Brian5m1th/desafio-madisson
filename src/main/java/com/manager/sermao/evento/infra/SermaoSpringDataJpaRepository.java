package com.manager.sermao.evento.infra;

import com.manager.sermao.evento.domain.Sermao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SermaoSpringDataJpaRepository extends JpaRepository<Sermao, UUID>{
}
