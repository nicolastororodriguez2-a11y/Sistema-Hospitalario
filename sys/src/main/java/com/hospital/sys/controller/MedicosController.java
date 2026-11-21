
package com.hospital.sys.controller;

import com.hospital.sys.model.Medicos;
import com.hospital.sys.service.MedicosService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicos")
public class MedicosController {
  private final MedicosService medicosService;
  
  public MedicosController(MedicosService ms){
      this.medicosService=ms;
  }
  @GetMapping("/ver")
  public List<Medicos> Listar(){
      return medicosService.Listar();
  }
  @GetMapping("/ver/{id}")
  public Medicos unMedico(@PathVariable Integer id){
      return medicosService.unMedico(id);
  }
  @PostMapping("/registrar")
  @ResponseStatus(HttpStatus.CREATED)
  public Medicos registrar(@PathVariable Integer id, @RequestBody Medicos med){
      return medicosService.registrarMedico(med);
  }
  
 
}
