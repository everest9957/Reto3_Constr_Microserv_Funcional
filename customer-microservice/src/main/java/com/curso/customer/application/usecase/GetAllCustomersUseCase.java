package com.curso.customer.application.usecase;

import com.curso.customer.domain.model.Customer;
import com.curso.customer.domain.service.CustomerService;
import java.util.List;

/**
 * ============================================================
 * CASO DE USO: GetAllCustomersUseCase
 * ============================================================
 * Representa la accion "Obtener todos los clientes".
 * ============================================================
 */
public class GetAllCustomersUseCase {

    private final CustomerService customerService;

    public GetAllCustomersUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> execute() {
        return customerService.findAllCustomers();
    }
}
