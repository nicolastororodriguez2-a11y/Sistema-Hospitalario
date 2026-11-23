
package com.hospital.sys.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "historias_clinicas")
@Data
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer pacienteId;
    private Integer medicoId;
    private LocalDate fecha;
    private String diagnostico; 
    private String tratatmiento;
    private String observaciones;
            
}
