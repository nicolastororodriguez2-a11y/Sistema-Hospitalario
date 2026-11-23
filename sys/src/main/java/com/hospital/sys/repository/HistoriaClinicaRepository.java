
package com.hospital.sys.repository;

import com.hospital.sys.model.HistoriaClinica;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer>{
    List<HistoriaClinica> findByFecha(LocalDate fecha);
}
