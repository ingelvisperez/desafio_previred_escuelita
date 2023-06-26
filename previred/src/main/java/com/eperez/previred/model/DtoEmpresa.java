package com.eperez.previred.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotaciones para el uso de Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DtoEmpresa {

    private Integer idEmpresa;
    private String rutEmpresa;
    private String razonSocial;
    private LocalDateTime fechaRegistro;    

}
