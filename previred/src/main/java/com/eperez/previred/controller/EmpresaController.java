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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eperez.previred.model.DtoEmpresa;
import com.eperez.previred.model.Empresa;
import com.eperez.previred.service.EmpresaService;

/*  @Controller:
    Es una anotación utilizada para marcar una clase que se encargará 
    de manejar solicitudes HTTP y enviar respuestas en forma de objetos
    Java serializados en formato JSON o XML. Sirve para especificar que 
    es una clase de tipo controlador
*/
/*  @CrossOrigin("*"):
    Sirve para especificar el origen de las peticiones, en este caso pueden
    venir de cualquier lado.
*/
@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/empresa")

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
    @PostMapping("/register")
    public void registerEmpresa(@RequestBody DtoEmpresa dtoEmpresa){
        empresaService.registerEmpresa(dtoEmpresa);
    }

    // PUT: Método para editar  en la BD
    @PutMapping("/update")
    public void updateEmpresa(@RequestBody Empresa empresa){
        empresaService.updateEmpresa(empresa);
    }

    // DELETE: Método para Eliminar/Borrar 
    @DeleteMapping("/delete/{id}")
    public void deleteEmpresa(@PathVariable Integer id){
        empresaService.deleteEmpresa(id);
    }

    // GET: Método que retorna todos 
    @GetMapping("/findAll")
    public List<Empresa> getEmpresa() {
        return empresaService.findAllEmpresa();
    }    

    

}
