
package com.hospital.sys.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "pacientes")
@Data
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idPaciente;
    private String nombre;
    private String apellido;
    private String documento;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String direccion;
    private String eps;
    @Enumerated(EnumType.STRING)
    private Enum genero;
}


