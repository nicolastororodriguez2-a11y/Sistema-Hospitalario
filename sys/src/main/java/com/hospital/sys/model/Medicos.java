
package com.hospital.sys.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "medicos")
@Data
public class Medicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;
    private String nombre;
    private String apellido;
    private String documento;
    private String especialidad;
    private String telefono;
    private String correo;
}
