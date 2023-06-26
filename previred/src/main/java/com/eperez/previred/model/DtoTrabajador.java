package com.eperez.previred.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DtoTrabajador {
    
    private Integer idTrabajador;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private Integer fkIdEmpresa;
    private String rutTrabajador;

}
