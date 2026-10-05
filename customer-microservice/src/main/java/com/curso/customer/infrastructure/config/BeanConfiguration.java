package com.curso.customer.infrastructure.config;

import com.curso.customer.application.usecase.CreateCustomerUseCase;
import com.curso.customer.application.usecase.GetAllCustomersUseCase;
import com.curso.customer.domain.repository.CustomerRepositoryPort;
import com.curso.customer.domain.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ============================================================
 * CONFIGURACION DE BEANS
 * ============================================================
 * Registra los beans del dominio y casos de uso en Spring.
 * ============================================================
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public CustomerService customerService(CustomerRepositoryPort repositoryPort) {
        return new CustomerService(repositoryPort);
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CustomerService customerService) {
        return new CreateCustomerUseCase(customerService);
    }

    @Bean
    public GetAllCustomersUseCase getAllCustomersUseCase(CustomerService customerService) {
        return new GetAllCustomersUseCase(customerService);
    }
}
