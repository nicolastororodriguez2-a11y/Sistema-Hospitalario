
package com.hospital.sys.controller;

import com.hospital.sys.model.Inventario;
import com.hospital.sys.service.InventarioService;
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
@RequestMapping("/api/inventario")
public class InventarioController {
    
    private final InventarioService inventarioService;
    
    public InventarioController(InventarioService is){
        this.inventarioService=is;
    }
    @GetMapping("/ver")
    public List<Inventario> listar(){
        return inventarioService.Listar();
    }
    @GetMapping("/ver/{id}")
     public Inventario unProducto(@PathVariable Integer id){
      return inventarioService.unProducto(id);
    }
    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario registrar(@PathVariable Integer id, @RequestBody Inventario inv){
        return inventarioService.registrar(inv);
    }
    @PutMapping("/actualiza/{id}")
     public Inventario actualizarProducto(@PathVariable Integer id,@RequestBody Inventario inv){
      return inventarioService.actualizarInventario(id, inv);
    } 
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
     inventarioService.borrar(id);
  }
}
