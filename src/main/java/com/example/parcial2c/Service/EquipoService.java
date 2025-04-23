package com.example.parcial2c.Service;

import com.example.parcial2c.Model.Equipo;
import com.example.parcial2c.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;


    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }


    public Optional<Equipo> getEquipoById(Long id) {
        return equipoRepository.findById(id);
    }


    public Equipo saveEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }


    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }


    public Equipo updateEquipo(Long id, Equipo equipoDetails) {
        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        equipo.setNombre(equipoDetails.getNombre());
        equipo.setCiudad(equipoDetails.getCiudad());
        return equipoRepository.save(equipo);
    }
}
