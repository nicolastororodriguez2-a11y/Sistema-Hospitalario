
package com.hospital.sys.repository;

import com.hospital.sys.model.Pacientes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<Pacientes, Integer>{
    List<Pacientes> findByNombre(String texto);
}