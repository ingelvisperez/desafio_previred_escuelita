package com.eperez.previred.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eperez.previred.model.DtoTrabajador;
import com.eperez.previred.model.Trabajador;
import com.eperez.previred.repository.TrabajadorRepository;

@Service

public class TrabajadorService {
    
    /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo TrabajadorRepository)        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz TrabajadorRepository 
        para interactuar con la base.
    */   
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo TrabajadorRepository.
     * 
     * Esto quiere decir que la instancia TrabajadorService que se crea
     * tendrá acceso a un objeto de EmpresaRepository y así poder 
     * interactuar con la base de datos
     */
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