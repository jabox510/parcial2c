package com.example.parcial2c.Controller;

import com.example.parcial2c.Model.Entrenador;
import com.example.parcial2c.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;


    @GetMapping("/")
    public ResponseEntity<List<Entrenador>> getAllEntrenadores() {
        return ResponseEntity.ok(entrenadorService.getAllEntrenadores());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Long id) {
        Optional<Entrenador> entrenador = entrenadorService.getEntrenadorById(id);
        return entrenador.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Entrenador> createEntrenador(@RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(entrenadorService.saveEntrenador(entrenador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id, @RequestBody Entrenador entrenadorDetails) {
        Entrenador updatedEntrenador = entrenadorService.updateEntrenador(id, entrenadorDetails);
        return ResponseEntity.ok(updatedEntrenador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }
}
