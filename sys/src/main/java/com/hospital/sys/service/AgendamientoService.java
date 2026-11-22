
package com.hospital.sys.service;

import com.hospital.sys.model.Agendamiento;
import com.hospital.sys.repository.AgendamientoRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AgendamientoService {
    private final AgendamientoRepository agendamientoRepository;
    
    public AgendamientoService(AgendamientoRepository ar){
        this.agendamientoRepository=ar;
    }
    public List<Agendamiento> Listar(){
        return agendamientoRepository.findAll();
    }
    public Agendamiento unAgendamiento(Integer id){
        return agendamientoRepository.findById(id).orElseThrow(()->{
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro agendamiento");
        });
    } 
      public Agendamiento registrar(Agendamiento age){
        return agendamientoRepository.save(age);
    }
    private void validarAgenda(Agendamiento age){
        if (age==null || age.getMotivo()== null || age.getMotivo().isBlank()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el motivo es obligatorio");
        }
        age.getMotivo(age.getMotivo().trim());
    }
    public Agendamiento actualizarAgendamiento(Integer id, Agendamiento age){
        validarAgenda(age);
        Inventario actualOException=unProducto(id);
        actualOException.setNombre(inv.getNombre());
        actualOException.setDescripcion(inv.getDescripcion());
        actualOException.setCantidad(inv.getCantidad());
        actualOException.setUnidad(inv.getUnidad());
        actualOException.setFechaRegistro(inv.getFechaRegistro());
        actualOException.setStockMinimo(inv.getStockMinimo());
        return inventarioRepository.save(actualOException);
    }
    public void borrar(Integer id){
        inventarioRepository.delete(unProducto(id));
    }
}
}
