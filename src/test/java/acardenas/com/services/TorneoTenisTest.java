package acardenas.com.services;

import acardenas.com.models.JugadorTenisFemenino;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TorneoTenisTest {

    @Test
    public void iniciarTorneoFemenino() throws Exception{
        List<JugadorTenisFemenino> jugadoresTenisFemeninos = new ArrayList<>();
        jugadoresTenisFemeninos.add( new JugadorTenisFemenino("Maria", 50, 4));
        jugadoresTenisFemeninos.add(new JugadorTenisFemenino("Juana", 70, 6));
        jugadoresTenisFemeninos.add( new JugadorTenisFemenino("Laura", 50,5));
        jugadoresTenisFemeninos.add(new JugadorTenisFemenino("Pilar", 60, 5));

        TorneoTenis<JugadorTenisFemenino> tenisFemenino = new TorneoTenisFemenino();
        tenisFemenino.iniciarTorneo(jugadoresTenisFemeninos);

    }
}