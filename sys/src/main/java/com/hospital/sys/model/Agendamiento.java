

package com.hospital.sys.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Entity
@Table(name = "agendamientos")
@Data
public class Agendamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idAgenda;
    private Integer pacienteId;
    private Integer medicoId;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private String motivo;
}
