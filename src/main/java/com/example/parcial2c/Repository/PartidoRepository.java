package com.example.parcial2c.Repository;

import com.example.parcial2c.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = "SELECT SUM(e.goles) FROM estadistica e " +
            "JOIN jugador j ON e.id_jugador = j.id_jugador " +
            "WHERE j.id_equipo = ?1", nativeQuery = true)
    int getTotalGolesByEquipo(Long equipoId);
}
