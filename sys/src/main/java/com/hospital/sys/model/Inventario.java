
package com.hospital.sys.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "inventario")
@Data
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInterio;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Integer stockMinimo;
    private String unidad;
    private LocalDate fechaRegistro;
}
