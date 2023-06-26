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

import com.eperez.previred.model.DtoTrabajador;
import com.eperez.previred.model.Trabajador;
import com.eperez.previred.service.TrabajadorService;

@Controller
@CrossOrigin("*")
@RestController

public class TrabajadorController {

    @Autowired
    TrabajadorService trabajadorService;

    public TrabajadorController(@Autowired TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Método para ingresar/registrar a la BD
    @PostMapping("/trabajador/register")
    public void registerTrabajador(@RequestBody DtoTrabajador dtoTrabajador){
        trabajadorService.registerTrabajador(dtoTrabajador);
    }

    // PUT: Método para editar  en la BD
    @PutMapping("/trabajador/update")
    public void updateTrabajador(@RequestBody Trabajador trabajador){
        trabajadorService.updateTrabajador(trabajador);
    }

    // DELETE: Método para Eliminar/Borrar 
    @DeleteMapping("/trabajador/delete/{id}")
    public void deleteEmpresa(@PathVariable Integer id){
        trabajadorService.deleteTrabajador(id);
    }

    // GET: Método que retorna todos 
    @GetMapping("/trabajador/findAll")
    public List<Trabajador> getTrabajador() {
        return trabajadorService.findAllTrabajador();
    }       
    


}
