package com.eperez.previred.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Empresas")

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Empresa {

    /* Representación de la tabla Empresas en Objeto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "rut_empresa")
    private String rutEmpresa;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

}
