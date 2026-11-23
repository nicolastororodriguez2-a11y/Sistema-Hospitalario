
package com.hospital.sys.repository;

import com.hospital.sys.model.Agendamiento;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamientoRepository extends JpaRepository<Agendamiento, Integer>{
        List<Agendamiento> findByMotivo(String texto);

        List<Agendamiento> findByEstado(String texto);

        List<Agendamiento> findByFecha(LocalDate fecha);
}
