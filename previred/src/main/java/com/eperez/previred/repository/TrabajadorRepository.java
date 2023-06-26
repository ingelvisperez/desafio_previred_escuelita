package com.eperez.previred.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eperez.previred.model.Trabajador;

@Repository

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
    /* Interfaz es la colección de métodos que se utilizarán */

}