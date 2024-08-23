package unah.hn.examen2_reposicion.servicios;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;

import unah.hn.examen2_reposicion.entidades.Posiciones;

import unah.hn.examen2_reposicion.entidades.Equipos;
import unah.hn.examen2_reposicion.repositorios.EquipoRepositorio;
import unah.hn.examen2_reposicion.repositorios.PosicionesRepositorio;

import java.util.List;

import java.util.Random;


public class PosicionesSevicios {


    @Autowired
    private PosicionesRepositorio posicionesRepositorio;

    @Autowired
    private EquipoRepositorio equipoRepositorio;

        private void actualizarPosiciones(Equipos equipoA, Equipos equipoB, int golesA, int golesB) {
        Posiciones posicionesA = posicionesRepositorio.findByEquipos(equipoA);
        if (posicionesA == null) {
            posicionesA = new Posiciones();
        }
    
        Posiciones posicionesB = posicionesRepositorio.findByEquipos(equipoB);
        if (posicionesB == null) {
            posicionesB = new Posiciones();
        }
        
        posicionesA.setEquipo(equipoA);
        posicionesB.setEquipo(equipoB);
        
        posicionesA.setGolesFavor(posicionesA.getGolesFavor() + golesA);
        posicionesA.setGolesContra(posicionesA.getGolesContra() + golesB);
        
        posicionesB.setGolesFavor(posicionesB.getGolesFavor() + golesB);
        posicionesB.setGolesContra(posicionesB.getGolesContra() + golesA);
        
        if (golesA > golesB) {
            posicionesA.setGanados(posicionesA.getGanados() + 1);
            posicionesA.setPuntos(posicionesA.getPuntos() + 3);
            posicionesB.setPerdidos(posicionesB.getPerdidos() + 1);
        } else if (golesA < golesB) {
            posicionesB.setGanados(posicionesB.getGanados() + 1);
            posicionesB.setPuntos(posicionesB.getPuntos() + 3);
            posicionesA.setPerdidos(posicionesA.getPerdidos() + 1);
        } else {
            posicionesA.setEmpates(posicionesA.getEmpates() + 1);
            posicionesA.setPuntos(posicionesA.getPuntos() + 1);
            posicionesB.setEmpates(posicionesB.getEmpates() + 1);
            posicionesB.setPuntos(posicionesB.getPuntos() + 1);
        }
        
        posicionesRepositorio.save(posicionesA);
        posicionesRepositorio.save(posicionesB);
    }

        public String simularPartidos() {
        List<Equipos> equipos = equipoRepositorio.findAll();

        if (equipos.size() < 6) {
            for (int i = equipos.size(); i < 6; i++) {
                Equipos nuevoEquipo = new Equipos();
                nuevoEquipo.setNombre("Equipo " + (i + 1));
                nuevoEquipo.setAtaque(new Random().nextDouble() * 10);
                nuevoEquipo.setDefensa(new Random().nextDouble() * 10);
                equipoRepositorio.save(nuevoEquipo);
            }
            equipos = equipoRepositorio.findAll();
        }

        Random random = new Random();
        
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipos equipoA = equipos.get(i);
                Equipos equipoB = equipos.get(j);
                
                for (int k = 0; k < 2; k++) {
                    int golesA = random.nextInt(5); 
                    int golesB = random.nextInt(5);
                    
                    actualizarPosiciones(equipoA, equipoB, golesA, golesB);
                }
            }
        }
        return "Partidos simulados y posiciones actualizadas.";
    }
}
