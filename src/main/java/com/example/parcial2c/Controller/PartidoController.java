package com.example.parcial2c.Controller;

import com.example.parcial2c.Model.Partido;
import com.example.parcial2c.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;


    @GetMapping("/")
    public ResponseEntity<List<Partido>> getAllPartidos() {
        return ResponseEntity.ok(partidoService.getAllPartidos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Long id) {
        Optional<Partido> partido = partidoService.getPartidoById(id);
        return partido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public ResponseEntity<Partido> createPartido(@RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.savePartido(partido));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Long id, @RequestBody Partido partidoDetails) {
        Partido updatedPartido = partidoService.updatePartido(id, partidoDetails);
        return ResponseEntity.ok(updatedPartido);
    }

    // Eliminar un partido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        partidoService.deletePartido(id);
        return ResponseEntity.noContent().build();  // Devuelve un 204 sin cuerpo
    }

    @GetMapping("/goles/{equipoId}")
    public ResponseEntity<Integer> getTotalGolesByEquipo(@PathVariable Long equipoId) {
        int totalGoles = partidoService.getTotalGolesByEquipo(equipoId);
        return ResponseEntity.ok(totalGoles);
    }
}
