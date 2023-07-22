package com.eperez.previred.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // @PostMapping("/register")
    // public void registroEmpresa(@RequestBody DtoEmpresa dtoEmpresa){
    //     empresaService.registroEmpresa(dtoEmpresa);
    // }
    @PostMapping("/register")
    public ResponseEntity<?> registroEmpresa(@RequestBody DtoEmpresa dtoEmpresa){
        Empresa empresaBD = empresaService.registroEmpresa(dtoEmpresa);

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaBD);
    }

    // PUT: Método para editar  en la BD
    // @PutMapping("/update")
    // public void actualizarEmpresa(@RequestBody Empresa empresa){
    //     empresaService.actualizarEmpresa(empresa);
    // }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarEmpresa(@RequestBody Empresa empresa, @PathVariable Integer id){
        
        Optional<Empresa> empresaOpcional = empresaService.buscarEmpresaPorId(id);
        if(empresaOpcional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.actualizarEmpresa(empresa));
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Método para Eliminar/Borrar 
    // @DeleteMapping("/delete/{id}")
    // public void borrarEmpresa(@PathVariable Integer id){
    //     empresaService.borrarEmpresa(id);
    // }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarEmpresa(@PathVariable Integer id){
        Optional<Empresa> empresaOpcional = empresaService.buscarEmpresaPorId(id);
        if(empresaOpcional.isPresent()){
            empresaService.borrarEmpresa(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET: Método que retorna todos 
    // @GetMapping("/findAll")
    // public List<Empresa> buscarEmpresas() {
    //     return empresaService.buscarEmpresas();
    // }  
    @GetMapping("/findAll")
    public ResponseEntity<List<Empresa>> buscarEmpresas() {
        return ResponseEntity.ok(empresaService.buscarEmpresas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEmpresaPorId(@PathVariable Integer id){
        Optional<Empresa> empresaOpcional = empresaService.buscarEmpresaPorId(id);
        if (empresaOpcional.isPresent()) {
            return ResponseEntity.ok(empresaOpcional.get());
        }
        return ResponseEntity.notFound().build();
    }

    

}
