package com.curso.customer.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ============================================================
 * REPOSITORIO JPA: CustomerJpaRepository
 * ============================================================
 * Interfaz de Spring Data JPA para operaciones CRUD.
 * ============================================================
 */
@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long> {
}
