package com.manager.sermao.sermao.infra;

import com.manager.sermao.sermao.domain.Sermao;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
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
