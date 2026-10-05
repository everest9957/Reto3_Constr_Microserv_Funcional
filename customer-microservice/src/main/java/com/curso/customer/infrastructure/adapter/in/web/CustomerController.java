package com.curso.customer.infrastructure.adapter.in.web;

import com.curso.customer.application.usecase.CreateCustomerUseCase;
import com.curso.customer.application.usecase.GetAllCustomersUseCase;
import com.curso.customer.domain.model.Customer;
import com.curso.customer.infrastructure.adapter.in.web.dto.CustomerRequest;
import com.curso.customer.infrastructure.adapter.in.web.dto.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ============================================================
 * ADAPTADOR DE ENTRADA: CustomerController
 * ============================================================
 * Expone los endpoints REST del microservicio.
 * Endpoints:
 *   POST /api/customers  -> Crear cliente
 *   GET  /api/customers  -> Listar clientes
 * ============================================================
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
                              GetAllCustomersUseCase getAllCustomersUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.getAllCustomersUseCase = getAllCustomersUseCase;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
        Customer customer = new Customer(null, request.getNombre(), request.getEmail());
        Customer saved = createCustomerUseCase.execute(customer);
        CustomerResponse response = new CustomerResponse(
                saved.getId(), saved.getNombre(), saved.getEmail()
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> response = getAllCustomersUseCase.execute()
                .stream()
                .map(c -> new CustomerResponse(c.getId(), c.getNombre(), c.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
