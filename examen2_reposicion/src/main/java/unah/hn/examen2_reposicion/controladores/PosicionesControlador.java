package unah.hn.examen2_reposicion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import unah.hn.examen2_reposicion.servicios.PosicionesServicios;

@RestController
@RequestMapping("/posiciones")
public class PosicionesControlador {

    @Autowired
    private PosicionesServicios posicionesServicios;

    @PostMapping("/simular")
    public ResponseEntity<String> simularPartidos() {
        String resultado = posicionesServicios.simularPartidos();
        return ResponseEntity.ok(resultado);
    }
}