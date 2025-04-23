package com.example.parcial2c.Controller;

import com.example.parcial2c.Model.Jugador;
import com.example.parcial2c.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;


    @GetMapping("/")
    public ResponseEntity<List<Jugador>> getAllJugadores() {
        return ResponseEntity.ok(jugadorService.getAllJugadores());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getJugadorById(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorService.getJugadorById(id);
        return jugador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.saveJugador(jugador));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable Long id, @RequestBody Jugador jugadorDetails) {
        Jugador updatedJugador = jugadorService.updateJugador(id, jugadorDetails);
        return ResponseEntity.ok(updatedJugador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<List<Jugador>> getJugadoresByEquipo(@PathVariable Long equipoId) {
        List<Jugador> jugadores = jugadorService.getJugadoresByEquipo(equipoId);
        return ResponseEntity.ok(jugadores);
    }

    @GetMapping("/goles/{goles}")
    public ResponseEntity<List<Jugador>> getJugadoresByGoles(@PathVariable int goles) {
        List<Jugador> jugadores = jugadorService.getJugadoresByGoles(goles);
        return ResponseEntity.ok(jugadores);
    }


}
