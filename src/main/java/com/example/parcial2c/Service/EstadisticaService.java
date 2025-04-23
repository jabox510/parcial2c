package com.example.parcial2c.Service;

import com.example.parcial2c.Model.Estadistica;
import com.example.parcial2c.Repository.EstadisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaService {

    @Autowired
    private EstadisticaRepository estadisticaRepository;

    public List<Estadistica> getAllEstadisticas() {
        return estadisticaRepository.findAll();
    }

    public Optional<Estadistica> getEstadisticaById(Long id) {
        return estadisticaRepository.findById(id);
    }

    public Estadistica saveEstadistica(Estadistica estadistica) {
        return estadisticaRepository.save(estadistica);
    }

    public void deleteEstadistica(Long id) {
        estadisticaRepository.deleteById(id);
    }

    public Estadistica updateEstadistica(Long id, Estadistica estadisticaDetails) {
        Estadistica estadistica = estadisticaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estadistica no encontrada"));
        estadistica.setMinutos_jugados(estadisticaDetails.getMinutos_jugados());
        estadistica.setGoles(estadisticaDetails.getGoles());
        estadistica.setAsistencias(estadisticaDetails.getAsistencias());
        estadistica.setTarjetas_amarillas(estadisticaDetails.getTarjetas_amarillas());
        estadistica.setTarjetas_rojas(estadisticaDetails.getTarjetas_rojas());
        return estadisticaRepository.save(estadistica);
    }
}
