package com.curso.customer.infrastructure.adapter.out.persistence;

import com.curso.customer.domain.model.Customer;
import com.curso.customer.domain.repository.CustomerRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ============================================================
 * ADAPTADOR DE SALIDA: CustomerPersistenceAdapter
 * ============================================================
 * Implementa el PUERTO CustomerRepositoryPort usando JPA.
 * ============================================================
 */
@Component
public class CustomerPersistenceAdapter implements CustomerRepositoryPort {

    private final CustomerJpaRepository jpaRepository;

    public CustomerPersistenceAdapter(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerJpaEntity entity = CustomerMapper.toEntity(customer);
        CustomerJpaEntity saved = jpaRepository.save(entity);
        return CustomerMapper.toDomain(saved);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id).map(CustomerMapper::toDomain);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(CustomerMapper::toDomain)
                .collect(Collectors.toList());
    }
}
