
package com.hospital.sys.repository;

import com.hospital.sys.model.Inventario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
    List<Inventario> findByNombre(String texto);
}
