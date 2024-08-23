package unah.hn.examen2_reposicion.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import unah.hn.examen2_reposicion.entidades.Equipos;

import unah.hn.examen2_reposicion.repositorios.EquipoRepositorio;

public class EquiposServicios {

    @Autowired
    private EquipoRepositorio equipoRepositorio;



    
    public Equipos crearEquipos (Equipos equipos){
        return equipoRepositorio.save(equipos);
    }

    public String eliminarEquipo(int codigoEquipos) {
    if (equipoRepositorio.existsById(codigoEquipos)) {
        return "No se puede eliminar el equipo porque no existe.";
    }
    equipoRepositorio.deleteById(codigoEquipos);
    return "Equipo eliminado.";
    }

    public String buscarEquipoId(int codigoEquipos){
        if (equipoRepositorio.existsById(codigoEquipos)) {
            return "Equipo encontrado: " + equipoRepositorio.findById(codigoEquipos).get();
        }
        return "No se encontró el equipo.";
    }
}
