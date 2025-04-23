package com.example.parcial2c.Repository;

import com.example.parcial2c.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = ?1", nativeQuery = true)
    List<Jugador> findByEquipoId(Long equipoId);

    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadistica e ON j.id_jugador = e.id_jugador " +
            "WHERE e.goles > ?1", nativeQuery = true)
    List<Jugador> findByGolesGreaterThan(int goles);

}

