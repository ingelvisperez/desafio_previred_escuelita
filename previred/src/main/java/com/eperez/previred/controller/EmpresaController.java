package com.eperez.previred.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eperez.previred.model.DtoEmpresa;
import com.eperez.previred.model.Empresa;
import com.eperez.previred.service.EmpresaService;

@Controller
@CrossOrigin("*")
@RestController

public class EmpresaController {
    
    @Autowired
    EmpresaService empresaService;

    public EmpresaController(@Autowired EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Método para ingresar/registrar a la BD
    @PostMapping("/empresa/register")
    public void registerEmpresa(@RequestBody DtoEmpresa dtoEmpresa){
        empresaService.registerEmpresa(dtoEmpresa);
    }

    // PUT: Método para editar  en la BD
    @PutMapping("/empresa/update")
    public void updateEmpresa(@RequestBody Empresa empresa){
        empresaService.updateEmpresa(empresa);
    }

    // DELETE: Método para Eliminar/Borrar 
    @DeleteMapping("/empresa/delete/{id}")
    public void deleteEmpresa(@PathVariable Integer id){
        empresaService.deleteEmpresa(id);
    }

    // GET: Método que retorna todos 
    @GetMapping("/empresa/findAll")
    public List<Empresa> getEmpresa() {
        return empresaService.findAllEmpresa();
    }    

    

}
