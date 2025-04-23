package com.example.parcial2c.Service;

import com.example.parcial2c.Model.Partido;
import com.example.parcial2c.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> getPartidoById(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido savePartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deletePartido(Long id) {
        partidoRepository.deleteById(id);
    }

    public Partido updatePartido(Long id, Partido partidoDetails) {
        Partido partido = partidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Partido no encontrado"));
        partido.setEstadio(partidoDetails.getEstadio());
        partido.setFecha(partidoDetails.getFecha());
        partido.setGoles_local(partidoDetails.getGoles_local());
        partido.setGoles_visitante(partidoDetails.getGoles_visitante());
        return partidoRepository.save(partido);
    }

    public int getTotalGolesByEquipo(Long equipoId) {
        return partidoRepository.getTotalGolesByEquipo(equipoId);
    }
}

