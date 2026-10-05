package com.curso.customer.domain.model;

/**
 * ============================================================
 * MODELO DE DOMINIO: Customer
 * ============================================================
 * Representa la entidad de negocio "Cliente" en el nucleo de la
 * aplicacion. Esta clase es PURA (no depende de frameworks) y
 * contiene las reglas de negocio esenciales.
 * ============================================================
 */
public class Customer {

    private Long id;
    private String nombre;
    private String email;

    public Customer() {
    }

    public Customer(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Valida que los datos del cliente sean correctos.
     */
    public void validar() {
        if (this.nombre == null || this.nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        if (this.email == null || this.email.isBlank()) {
            throw new IllegalArgumentException("El email del cliente es obligatorio");
        }
        if (!this.email.contains("@")) {
            throw new IllegalArgumentException("El email debe tener un formato valido");
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
