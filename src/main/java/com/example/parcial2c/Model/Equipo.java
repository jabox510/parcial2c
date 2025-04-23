package com.example.parcial2c.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;  // Importar esta anotación
import java.util.List;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipo;

    private String nombre;
    private String ciudad;
    private Date fechafundacion;

    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference
    private List<Entrenador> entrenadores;
}

