package com.eperez.previred.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eperez.previred.model.Trabajador;


@Repository

/* Interfaz es la colección de métodos que se utilizarán */
public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
    Optional<Trabajador> findByRutTrabajador(String rutTrabajador);


}
