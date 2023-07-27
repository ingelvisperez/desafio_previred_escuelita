package com.eperez.previred.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Trabajadores")

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Trabajador {

    /* Representación de la tabla Trabajadores en Objeto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    private Integer idTrabajador;

    // NotEmpty es para String, NotNull para Long, Integer, Date, etc.
    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column
    private String apellidoPaterno;

    @NotBlank
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @NotBlank
    @Column(name = "direccion")
    private String direccion;

    @NotNull
    @Column(name = "fk_id_empresa") 
    private Integer fkIdEmpresa;

    @NotBlank
    @Column(name = "rut_trabajador", unique = true)
    private String rutTrabajador;

}
