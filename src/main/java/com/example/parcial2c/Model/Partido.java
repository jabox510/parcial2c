package com.example.parcial2c.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partido;

    private String nombre;
    private Date fecha;


}