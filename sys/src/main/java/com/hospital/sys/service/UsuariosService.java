    
package com.hospital.sys.service;

import com.hospital.sys.model.Usuarios;
import com.hospital.sys.repository.UsuariosRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuariosService {
    
    private final UsuariosRepository usuariosRepository;

    public UsuariosService(UsuariosRepository u) {
        this.usuariosRepository=u;
        
    }
       public List<Usuarios> ListarUsuarios(){
       return usuariosRepository.findAll();
    }

    public Usuarios unUsuario(Integer id){
        return usuariosRepository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"no se encontro un usuario");
        });
    }
    public Usuarios regitrarUsuario(Usuarios usu){
        return usuariosRepository.save(usu);
    }
    public Usuarios actualizarUsuario(Integer id, Usuarios usu){
        validarUsuario(usu);
        Usuarios actualOExistente = unUsuario(id);
        actualOExistente.setUsuario(usu.getUsuario());
        actualOExistente.setContrasena(usu.getContrasena());
        actualOExistente.setRol(usu.getRol());
        return usuariosRepository.save(actualOExistente);
    }
    private void validarUsuario(Usuarios usu){
        if (usu == null || usu.getUsuario()== null || usu.getUsuario().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario es obligatorio");
        }
        usu.setUsuario(usu.getUsuario().trim());
    }
    public void borrar(Integer id){
        usuariosRepository.delete(unUsuario(id));
    }
   
    
}
