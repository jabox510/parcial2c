package com.example.parcial2c.Service;

import com.example.parcial2c.Model.Entrenador;
import com.example.parcial2c.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> getEntrenadorById(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador saveEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(Long id) {
        entrenadorRepository.deleteById(id);
    }

    public Entrenador updateEntrenador(Long id, Entrenador entrenadorDetails) {
        Entrenador entrenador = entrenadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        entrenador.setNombre(entrenadorDetails.getNombre());
        entrenador.setEspecialidad(entrenadorDetails.getEspecialidad());
        return entrenadorRepository.save(entrenador);
    }
}
