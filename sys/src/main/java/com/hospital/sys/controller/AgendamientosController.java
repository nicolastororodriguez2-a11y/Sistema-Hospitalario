
package com.hospital.sys.controller;

import com.hospital.sys.model.Agendamiento;
import com.hospital.sys.service.AgendamientoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendamientos")
public class AgendamientosController {
    private final AgendamientoService agendamientoService;
    
    public AgendamientosController(AgendamientoService as){
        this.agendamientoService=as;
    }
    @GetMapping("/ver")
    public List<Agendamiento> listar(){
        return agendamientoService.Listar();
    }
    @GetMapping("/ver/{id}")
     public Agendamiento unAgendamiento(@PathVariable Integer id){
      return agendamientoService.unAgendamiento(id);
    }
    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamiento registrar(@PathVariable Integer id, @RequestBody Agendamiento age){
        return agendamientoService.registrar(age);
    }
    @PutMapping("/actualiza/{id}")
     public Agendamiento actualizar(@PathVariable Integer id,@RequestBody Agendamiento age){
      return agendamientoService.actualizarAgendamiento(id, age);
    } 
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
    agendamientoService.borrar(id);
  }
}
