package com.vedruna.equipos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vedruna.equipos.DTO.EquipoDTO;
import com.vedruna.equipos.DTO.PrimeEquipoDTO;
import com.vedruna.equipos.Persistance.model.Equipo;
import com.vedruna.equipos.Persistance.repository.EquipoRepositoryI;

public class EquipoServiceImpl implements EquipoServiceI {

    @Autowired
    private EquipoRepositoryI equipoRepo;

    @Override
    public List<PrimeEquipoDTO> findAll() {
       List<Equipo> equipos = equipoRepo.findAll();
       List<PrimeEquipoDTO> primeEquipos = new ArrayList<>();
       for (Equipo equipo : equipos) {
           primeEquipos.add(new PrimeEquipoDTO(equipo));
       }
       return primeEquipos;
    }

    @Override
    public PrimeEquipoDTO findByName(String name) {
        try{
            return new PrimeEquipoDTO(equipoRepo.findByNombre(name));
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public void save(EquipoDTO equipo) {
        Equipo newEquipo = new Equipo();
        newEquipo.setNombre(equipo.getNombre());
        equipoRepo.save(newEquipo);
    }

    @Override
    public void delete(int idEquipo) {
        equipoRepo.deleteByIdEquipo(idEquipo);
    }

    public String test(){
        return "Working";
    }
    
}
