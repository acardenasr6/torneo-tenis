package acardenas.com.services;

import acardenas.com.models.JugadorTenisFemenino;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class TorneoTenisFemenino extends TorneoTenis<JugadorTenisFemenino>{

    @Override
    public JugadorTenisFemenino calcularPuntajeAdicional(JugadorTenisFemenino primerJugador, JugadorTenisFemenino segundoJugador) {

        if (Objects.equals(primerJugador.getTiempoReaccionSegundos(), segundoJugador.getTiempoReaccionSegundos())){
            return (Math.random() * 1 == 1) ? primerJugador : segundoJugador;
        }

        if(primerJugador.getTiempoReaccionSegundos() > segundoJugador.getTiempoReaccionSegundos()){
            return primerJugador;
        }else {
            return segundoJugador;
        }
    }

}
