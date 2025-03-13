package com.manager.sermao.sermao.infra;

import com.manager.sermao.sermao.domain.Sermao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface SermaoSpringDataJpaRepository extends JpaRepository<Sermao, UUID>, JpaSpecificationExecutor<Sermao> {
}