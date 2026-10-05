package com.curso.customer.infrastructure.adapter.out.persistence;

import com.curso.customer.domain.model.Customer;

/**
 * ============================================================
 * MAPPER: CustomerMapper
 * ============================================================
 * Convierte entre modelo de DOMINIO y ENTIDAD JPA.
 * ============================================================
 */
public class CustomerMapper {

    public static Customer toDomain(CustomerJpaEntity entity) {
        if (entity == null) return null;
        return new Customer(entity.getId(), entity.getNombre(), entity.getEmail());
    }

    public static CustomerJpaEntity toEntity(Customer domain) {
        if (domain == null) return null;
        return new CustomerJpaEntity(domain.getId(), domain.getNombre(), domain.getEmail());
    }
}
