package com.eperez.previred.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eperez.previred.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
    /* Interfaz es la colección de métodos que se utilizarán */
}
