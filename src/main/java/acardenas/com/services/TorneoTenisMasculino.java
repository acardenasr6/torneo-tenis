package acardenas.com.services;

import acardenas.com.models.JugadorTenisMasculino;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class TorneoTenisMasculino extends TorneoTenis<JugadorTenisMasculino> {
    @Override
    public JugadorTenisMasculino calcularPuntajeAdicional(JugadorTenisMasculino primerJugador, JugadorTenisMasculino segundoJugador) {

        return Math.random() * 1 == 1 ? ganadorPorFuerza(primerJugador, segundoJugador) :
                ganadorPrVelocidadDesplazamiento(primerJugador, segundoJugador);

    }

    private JugadorTenisMasculino ganadorPorFuerza(JugadorTenisMasculino primerJugador, JugadorTenisMasculino segundoJugador) {

        if (Objects.equals(primerJugador.getFuerza(), segundoJugador.getFuerza())) {
            return (Math.random() * 1 == 1) ? primerJugador : segundoJugador;
        }

        if (primerJugador.getFuerza() > segundoJugador.getFuerza()) {
            return primerJugador;
        } else {
            return segundoJugador;
        }
    }

    private JugadorTenisMasculino ganadorPrVelocidadDesplazamiento(JugadorTenisMasculino primerJugador, JugadorTenisMasculino segundoJugador) {
        if (Objects.equals(primerJugador.getVelocidadDesplazamiento(), segundoJugador.getVelocidadDesplazamiento())) {
            return (Math.random() * 1 == 1) ? primerJugador : segundoJugador;
        }

        if (primerJugador.getVelocidadDesplazamiento() > segundoJugador.getFuerza()) {
            return primerJugador;
        } else {
            return segundoJugador;
        }
    }
}
