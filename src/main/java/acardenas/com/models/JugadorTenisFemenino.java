package acardenas.com.models;

public class JugadorTenisFemenino extends JugadorTenis{

    private Integer tiempoReaccionSegundos;

    public JugadorTenisFemenino(String nombre, Integer nivelHabilidad, Integer tiempoReaccionSegundos) {
        super(nombre, nivelHabilidad);
        this.tiempoReaccionSegundos = tiempoReaccionSegundos;
    }

    public Integer getTiempoReaccionSegundos() {
        return tiempoReaccionSegundos;
    }

    public void setTiempoReaccionSegundos(Integer tiempoReaccionSegundos) {
        this.tiempoReaccionSegundos = tiempoReaccionSegundos;
    }

}
