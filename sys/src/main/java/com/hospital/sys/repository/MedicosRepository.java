
package com.hospital.sys.repository;

import com.hospital.sys.model.Medicos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<Medicos, Integer>{
    List<Medicos> findByNombre(String nombre);
}
