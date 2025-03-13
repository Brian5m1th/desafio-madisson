package com.manager.sermao.sermao.infra;

import com.manager.sermao.sermao.domain.Sermao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;



public class SermaoSpecifications {

    public static Specification<Sermao> hasIgreja(String igreja) {
        return (root, query, builder) -> {
            if (igreja == null) {
                return builder.conjunction();
            }
            return builder.equal(root.get("igreja"), igreja);
        };
    }

    public static Specification<Sermao> hasTema(String tema) {
        return (root, query, builder) -> {
            if (tema == null) {
                return builder.conjunction();
            }
            return builder.equal(root.get("tema"), tema);
        };
    }

    public static Specification<Sermao> hasData(LocalDateTime data) {
        return (root, query, builder) -> {
            if (data == null) {
                return builder.conjunction();
            }
            return builder.equal(root.get("data"), data);
        };
    }
}

