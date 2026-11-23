
package com.hospital.sys.service;

import com.hospital.sys.model.Inventario;
import com.hospital.sys.repository.InventarioRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InventarioService {
    private final InventarioRepository inventarioRepository;
    
    public InventarioService(InventarioRepository ir){
        this.inventarioRepository=ir;
    }
    public List<Inventario> Listar(){
        return inventarioRepository.findAll();
    }
    public Inventario unProducto(Integer id){
        return inventarioRepository.findById(id).orElseThrow(()->{
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro el producto");
        });
    }
    public Inventario registrar(Inventario inv){
        return inventarioRepository.save(inv);
    }
    private void validarProducto(Inventario inv){
        if (inv==null || inv.getNombre() == null || inv.getNombre().isBlank()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el nombre es obligatorio");
        }
        inv.setNombre(inv.getNombre().trim());
    }
    public Inventario actualizarInventario(Integer id, Inventario inv){
        validarProducto(inv);
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