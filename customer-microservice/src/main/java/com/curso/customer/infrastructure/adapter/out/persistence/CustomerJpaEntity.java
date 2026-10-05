package com.curso.customer.infrastructure.adapter.out.persistence;

import jakarta.persistence.*;

/**
 * ============================================================
 * ENTIDAD JPA: CustomerJpaEntity
 * ============================================================
 * Representa la tabla "customers" en la base de datos.
 * Es un objeto de INFRAESTRUCTURA, separado del dominio.
 * ============================================================
 */
@Entity
@Table(name = "customers")
public class CustomerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    public CustomerJpaEntity() {}

    public CustomerJpaEntity(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
