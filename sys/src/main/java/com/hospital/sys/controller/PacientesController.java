
package com.hospital.sys.controller;

import com.hospital.sys.model.Pacientes;
import com.hospital.sys.service.PacientesService;
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
@RequestMapping("/api/Pacientes")
public class PacientesController {
    
    private final PacientesService pacientesService;
    
    public PacientesController(PacientesService ps){
        this.pacientesService = ps;

    }
    @GetMapping("/ver")
    public  List<Pacientes> Listar(){
        return pacientesService.listarPacientes();
    }
    @GetMapping("/ver/{id}")
    public Pacientes unPacienteses(@PathVariable Integer id){
        return pacientesService.unPaciente(id);
    }
    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pacientes regitrar(@RequestBody Pacientes pac){
        return pacientesService.registrarPaciente(pac);
    }
    @PutMapping("/actualizar/{id}")
    public Pacientes actualizar(@PathVariable Integer id, @RequestBody Pacientes pac){
        return pacientesService.actualizarPaciente(id, pac);
    }
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        pacientesService.borrar(id);
    }
}
