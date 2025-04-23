package com.example.parcial2c.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;  // Importar esta anotación
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;

    private String nombre;
    private String posicion;
    private int dorsal;
    private Date fecha_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonBackReference
    private Equipo equipo;
}
