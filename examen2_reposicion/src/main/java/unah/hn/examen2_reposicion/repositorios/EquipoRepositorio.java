package unah.hn.examen2_reposicion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.hn.examen2_reposicion.entidades.Equipos;

public interface EquipoRepositorio extends JpaRepository<Equipos, Integer>{
    
}
