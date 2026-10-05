package com.curso.customer.application.usecase;

import com.curso.customer.domain.model.Customer;
import com.curso.customer.domain.service.CustomerService;

/**
 * ============================================================
 * CASO DE USO: CreateCustomerUseCase
 * ============================================================
 * Representa la accion "Crear un nuevo cliente".
 * ============================================================
 */
public class CreateCustomerUseCase {

    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer execute(Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
