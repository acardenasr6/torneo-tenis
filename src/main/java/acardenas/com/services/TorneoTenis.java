package acardenas.com.services;

import acardenas.com.exception.ValidationException;
import acardenas.com.models.JugadorTenis;

import java.util.*;


public abstract class TorneoTenis<T extends JugadorTenis> {

    protected List<T> jugadorTenisList;

    public TorneoTenis() {
        this.jugadorTenisList = new ArrayList<>();
    }

    public T iniciarTorneo(List<T> jugadorTenisList) throws ValidationException {
        this.jugadorTenisList = jugadorTenisList;

        if (this.jugadorTenisList.size() == 1){
            return jugadorTenisList.get(0);
        }

        if (Boolean.FALSE.equals(esJugadoresPotenciaDe2(jugadorTenisList.size()))){
            throw new ValidationException("Error, número de jugadores no es potencia de 2");
        }

        T ganadorTorneo = null;
        List<T> jugadores = extraerLosDosPrimeroJugadores();
        T primerJugador = jugadores.get(0);
        T segundoJugador = jugadores.get(1);

        while (!jugadores.isEmpty()){
           ganadorTorneo = enfrentarJugadores(new ArrayList<>(), primerJugador,segundoJugador);
            jugadores = extraerLosDosPrimeroJugadores();
            if (jugadores.isEmpty()){
                System.out.println("Ganó: " + ganadorTorneo.getNombre());
            }
        }
        return ganadorTorneo;
    }

    private T enfrentarJugadores(List<T> ganadoresFase, T primerJugador, T segundoJugador){
        ganadoresFase.add(calcularGanador(primerJugador,segundoJugador));

        if (this.jugadorTenisList.isEmpty() && ganadoresFase.size() > 1){
            this.jugadorTenisList.addAll(ganadoresFase);
            ganadoresFase.clear();
        }
        return ganadoresFase.get(0);
    }

    private List<T> extraerLosDosPrimeroJugadores(){

        if (this.jugadorTenisList.size() > 1){
            Random random = new Random();
            T primerJugador = this.jugadorTenisList.get(random.nextInt(this.jugadorTenisList.size()));
            this.jugadorTenisList.remove(primerJugador);
            T segundoJugador = this.jugadorTenisList.get(random.nextInt(this.jugadorTenisList.size()));
            this.jugadorTenisList.remove(segundoJugador);
            return Arrays.asList(primerJugador,segundoJugador);
        }else {
            return Collections.emptyList();
        }

    }

    private T calcularGanador(T primerJugador, T segundoJugador){

        if (Math.random() * 1 == 1){
            return calcularPorHabilidadYPuntajeAdicional(primerJugador, segundoJugador);
        }else {
            return (Math.random() * 1 == 1) ? primerJugador : segundoJugador;
        }
    }

    private T calcularPorHabilidadYPuntajeAdicional(T primerJugador, T segundoJugador){

        if (Objects.equals(primerJugador.getNivelHabilidad(), segundoJugador.getNivelHabilidad())){
            return calcularPuntajeAdicional(primerJugador, segundoJugador);
        }

        if (primerJugador.getNivelHabilidad() > segundoJugador.getNivelHabilidad()){
            return primerJugador;
        }else {
            return segundoJugador;
        }

    }
    public abstract T calcularPuntajeAdicional(T primerJugador, T segundoJugador);

    private Boolean esJugadoresPotenciaDe2(double totalJugadores){
        if (totalJugadores == 1) {
            return true;
        }else if (totalJugadores > 1){
            return esJugadoresPotenciaDe2(totalJugadores / 2);
        }
        return false;
    }

}
