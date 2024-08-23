package unah.hn.examen2_reposicion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import unah.hn.examen2_reposicion.entidades.Equipos;
import unah.hn.examen2_reposicion.servicios.EquiposServicios;

@RestController
@RequestMapping("/equipos")
public class EquiposControlador {

    @Autowired
    private EquiposServicios equiposServicios;

    @PostMapping("/crear")
    public ResponseEntity<Equipos> crearEquipos(@RequestBody Equipos equipos) {
        Equipos nuevoEquipo = equiposServicios.crearEquipos(equipos);
        return ResponseEntity.ok(nuevoEquipo);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEquipo(@PathVariable("id") int id) {
        String resultado = equiposServicios.eliminarEquipo(id);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<String> buscarEquipoId(@PathVariable("id") int id) {
        String resultado = equiposServicios.buscarEquipoId(id);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/simular")
    public ResponseEntity<String> simularPartidos() {
        String resultado = equiposServicios.simularPartidos();
        return ResponseEntity.ok(resultado);
    }
}
