package com.curso.customer.domain.repository;

import com.curso.customer.domain.model.Customer;
import java.util.List;
import java.util.Optional;

/**
 * ============================================================
 * PUERTO DE SALIDA (Output Port): CustomerRepositoryPort
 * ============================================================
 * Define el CONTRATO que la infraestructura debe implementar
 * para persistir los datos. Pertenece al DOMINIO.
 * ============================================================
 */
public interface CustomerRepositoryPort {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();
}
