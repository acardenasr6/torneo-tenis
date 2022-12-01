package acardenas.com.controller;

import acardenas.com.exception.ValidationException;
import acardenas.com.models.JugadorTenisFemenino;
import acardenas.com.models.JugadorTenisMasculino;
import acardenas.com.services.TorneoTenisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/torneo-tenis")
public class TorneoTenisController {
    private final TorneoTenisService torneoTenisService;

    @Autowired
    public TorneoTenisController(TorneoTenisService torneoTenisService) {
       this.torneoTenisService = torneoTenisService;
    }
    @Operation(summary = "Iniciar torneo de tenis femenino")

    @PostMapping(path = "/femenino",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> iniciarTorneoFemenino(@RequestBody List<JugadorTenisFemenino> jugadorTenisFemeninoList) throws ValidationException {
        return ResponseEntity
                .ok()
                .body(torneoTenisService.iniciarTorneoFemenino(jugadorTenisFemeninoList));
    }

    @Operation(summary = "Iniciar torneo de tenis masculino")

    @PostMapping(path = "/masculino",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> iniciarTorneoMasculino(@RequestBody List<JugadorTenisMasculino> jugadorTenisMasculinoList) throws ValidationException {
        return ResponseEntity
                .ok()
                .body(torneoTenisService.iniciarTorneoMasculino(jugadorTenisMasculinoList));
    }
}
