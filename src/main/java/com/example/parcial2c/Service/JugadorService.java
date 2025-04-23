package com.example.parcial2c.Service;

import com.example.parcial2c.Model.Jugador;
import com.example.parcial2c.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getJugadoresByEquipo(Long equipoId) {
              return jugadorRepository.findByEquipoId(equipoId);
    }

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> getJugadorById(Long id) {
        return jugadorRepository.findById(id);
    }

    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);
    }

    public Jugador updateJugador(Long id, Jugador jugadorDetails) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugador.setNombre(jugadorDetails.getNombre());
        jugador.setPosicion(jugadorDetails.getPosicion());
        jugador.setDorsal(jugadorDetails.getDorsal());
        jugador.setFecha_nac(jugadorDetails.getFecha_nac());
        jugador.setNacionalidad(jugadorDetails.getNacionalidad());
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> getJugadoresByGoles(int goles) {
        return jugadorRepository.findByGolesGreaterThan(goles);
    }
}
