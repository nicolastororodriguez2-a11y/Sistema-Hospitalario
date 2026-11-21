
package com.hospital.sys.controller;

import com.hospital.sys.model.Usuarios;
import com.hospital.sys.service.UsuariosService;
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
@RequestMapping("/api/usuarios")
public class UsuariosController {
    private final UsuariosService usuariosService;
    
    public UsuariosController(UsuariosService us){
        this.usuariosService =us;
    }
    @GetMapping("/ver")
    public List<Usuarios> Listar(){
    return usuariosService.ListarUsuarios();
    }
    @GetMapping("ver/{id}")
    public Usuarios unUsuario(@PathVariable Integer id){
        return usuariosService.unUsuario(id);
    } 
    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios regitrar(@RequestBody Usuarios usu){
        return usuariosService.regitrarUsuario(usu);
    }
    @PutMapping("/actualizar/{id}")
    public Usuarios actualizar(@PathVariable Integer id, @RequestBody Usuarios usu){
        return usuariosService.actualizarUsuario(id, usu);
    }
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id){
        usuariosService.borrar(id);
    }
    
}
