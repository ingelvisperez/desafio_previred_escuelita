package com.eperez.previred.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eperez.previred.model.DtoEmpresa;
import com.eperez.previred.model.Empresa;
import com.eperez.previred.repository.EmpresaRepository;


@Service

public class EmpresaService {

    /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo EmpresaRepository)        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz EmpresaRepository 
        para interactuar con la base.
    */   
    @Autowired
    private EmpresaRepository empresaRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo EmpresaRepository.
     * 
     * Esto quiere decir que la instancia EmpresaService que se crea
     * tendrá acceso a un objeto de EmpresaRepository y así poder 
     * interactuar con la base de datos
     */
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método para Registrar una Empresa
    public Empresa registerEmpresa(DtoEmpresa dtoEmpresa){
        Empresa empresaActual = new Empresa();

        empresaActual.setRutEmpresa(dtoEmpresa.getRutEmpresa());
        empresaActual.setRazonSocial(dtoEmpresa.getRazonSocial());
        empresaActual.setFechaRegistro(dtoEmpresa.getFechaRegistro());

        return empresaRepository.save(empresaActual);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateEmpresa(Empresa empresa){
        this.empresaRepository.save(empresa);
    }

    // Método para BORRAR/DELETE
    public void deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Empresa> findAllEmpresa(){
        return empresaRepository.findAll();
    }   
    



}
