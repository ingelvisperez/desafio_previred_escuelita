package com.eperez.previred.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eperez.previred.model.DtoTrabajador;
import com.eperez.previred.model.Trabajador;
import com.eperez.previred.repository.TrabajadorRepository;

@Service

public class TrabajadorService {
    
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método para Registrar a un trabajador
    public Trabajador registerTrabajador(DtoTrabajador dtoTrabajador){
        
        Trabajador trabajadorActual = new Trabajador();

        trabajadorActual.setRutTrabajador(dtoTrabajador.getRutTrabajador());
        trabajadorActual.setNombre(dtoTrabajador.getNombre());
        trabajadorActual.setApellidoPaterno(dtoTrabajador.getApellidoPaterno());
        trabajadorActual.setApellidoMaterno(dtoTrabajador.getApellidoMaterno());
        trabajadorActual.setDireccion(dtoTrabajador.getDireccion());
        trabajadorActual.setFkIdEmpresa(dtoTrabajador.getFkIdEmpresa());

        return trabajadorRepository.save(trabajadorActual);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateTrabajador(Trabajador trabajador){
        this.trabajadorRepository.save(trabajador);
    }

    // Método para BORRAR/DELETE
    public void deleteTrabajador(Integer id){
        trabajadorRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Trabajador> findAllTrabajador(){
        return trabajadorRepository.findAll();
    }       
}
