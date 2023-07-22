package com.eperez.previred.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseCookie.ResponseCookieBuilder;
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

import com.eperez.previred.model.DtoTrabajador;
import com.eperez.previred.model.Trabajador;
import com.eperez.previred.service.TrabajadorService;


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
@RequestMapping("/trabajador")

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
    // @PostMapping("/register")
    // public void registerTrabajador(@RequestBody DtoTrabajador dtoTrabajador){
    //     trabajadorService.registerTrabajador(dtoTrabajador);
    // }
    @PostMapping("/register")
    public ResponseEntity<?> registroTrabajador(@RequestBody DtoTrabajador dtoTrabajador){
        
        Trabajador trabajadorBD = trabajadorService.registroTrabajador(dtoTrabajador);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorBD);
    }

    // PUT: Método para editar  en la BD
    // @PutMapping("/update")
    // public void actualizarTrabajador(@RequestBody Trabajador trabajador){
    //     trabajadorService.actualizarTrabajador(trabajador);
    // }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarTrabajador(@RequestBody Trabajador trabajador, @PathVariable Integer id){
        Optional<Trabajador> trabajadorOpcional = trabajadorService.buscarTrabajadorPorId(id);
        if (trabajadorOpcional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(trabajadorService.actualizarTrabajador(trabajador));
        }

        return ResponseEntity.notFound().build();
    }    

    // DELETE: Método para Eliminar/Borrar 
    // @DeleteMapping("/delete/{id}")
    // public void eliminarTrabajador(@PathVariable Integer id){
    //     trabajadorService.eliminarTrabajador(id);
    // }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarTrabajador(@PathVariable Integer id){
        Optional<Trabajador> trabajadorOpcional = trabajadorService.buscarTrabajadorPorId(id);
        if (trabajadorOpcional.isPresent()) {
            trabajadorService.eliminarTrabajador(id);
            return ResponseEntity.noContent().build();            
        }
        
        return ResponseEntity.notFound().build();
    }

    // GET: Método que retorna a todos los trabajadores 
    @GetMapping("/findAll")
    public ResponseEntity<List<Trabajador>> buscarTrabajadores() {
        return ResponseEntity.ok(trabajadorService.buscarTrabajadores());
    }     
    
    // GET: Método que retorna un trabajador por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTrabajadorPorId(@PathVariable Integer id){
        Optional<Trabajador> trabajadorOpcional = trabajadorService.buscarTrabajadorPorId(id);
        if(trabajadorOpcional.isPresent()){
            return ResponseEntity.ok(trabajadorOpcional.get());
        }
        
        return ResponseEntity.notFound().build();
    }


    


}
