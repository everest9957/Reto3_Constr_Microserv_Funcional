package com.curso.customer.infrastructure.adapter.in.web.dto;

/**
 * ============================================================
 * DTO DE ENTRADA: CustomerRequest
 * ============================================================
 * Objeto que representa la peticion HTTP para crear un cliente.
 * Separa el modelo de dominio de la capa web.
 * ============================================================
 */
public class CustomerRequest {

    private String nombre;
    private String email;

    public CustomerRequest() {}

    public CustomerRequest(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
