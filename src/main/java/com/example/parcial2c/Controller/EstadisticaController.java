package com.example.parcial2c.Controller;

import com.example.parcial2c.Model.Estadistica;
import com.example.parcial2c.Service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    @Autowired
    private EstadisticaService estadisticaService;


    @GetMapping("/")
    public ResponseEntity<List<Estadistica>> getAllEstadisticas() {
        return ResponseEntity.ok(estadisticaService.getAllEstadisticas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Estadistica> getEstadisticaById(@PathVariable Long id) {
        Optional<Estadistica> estadistica = estadisticaService.getEstadisticaById(id);
        return estadistica.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/")
    public ResponseEntity<Estadistica> createEstadistica(@RequestBody Estadistica estadistica) {
        return ResponseEntity.ok(estadisticaService.saveEstadistica(estadistica));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadistica> updateEstadistica(@PathVariable Long id, @RequestBody Estadistica estadisticaDetails) {
        Estadistica updatedEstadistica = estadisticaService.updateEstadistica(id, estadisticaDetails);
        return ResponseEntity.ok(updatedEstadistica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadistica(@PathVariable Long id) {
        estadisticaService.deleteEstadistica(id);
        return ResponseEntity.noContent().build();  // Devuelve un 204 sin cuerpo
    }
}
