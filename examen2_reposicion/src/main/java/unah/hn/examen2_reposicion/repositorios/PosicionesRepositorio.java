package unah.hn.examen2_reposicion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.hn.examen2_reposicion.entidades.Equipos;
import unah.hn.examen2_reposicion.entidades.Posiciones;

public interface PosicionesRepositorio extends JpaRepository<Posiciones, Integer>{

    Posiciones findByEquipos(Equipos equipoA);
    
}
