package com.curso.customer.domain.service;

import com.curso.customer.domain.model.Customer;
import com.curso.customer.domain.repository.CustomerRepositoryPort;
import java.util.List;

/**
 * ============================================================
 * SERVICIO DE DOMINIO: CustomerService
 * ============================================================
 * Contiene la logica de negocio relacionada con Customer.
 * Usa el PUERTO de repositorio sin conocer la infraestructura.
 * ============================================================
 */
public class CustomerService {

    private final CustomerRepositoryPort repositoryPort;

    public CustomerService(CustomerRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public Customer saveCustomer(Customer customer) {
        customer.validar();
        return repositoryPort.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return repositoryPort.findAll();
    }
}
