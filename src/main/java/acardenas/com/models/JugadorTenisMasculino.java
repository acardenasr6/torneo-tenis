package acardenas.com.models;

public class JugadorTenisMasculino extends JugadorTenis{

    private Integer fuerza;
    private Integer velocidadDesplazamiento;

    public JugadorTenisMasculino(String nombre, Integer nivelHabilidad, Integer fuerza, Integer velocidadDesplazamiento) {
        super(nombre, nivelHabilidad);
        this.fuerza = fuerza;
        this.velocidadDesplazamiento = velocidadDesplazamiento;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getVelocidadDesplazamiento() {
        return velocidadDesplazamiento;
    }

    public void setVelocidadDesplazamiento(Integer velocidad) {
        this.velocidadDesplazamiento = velocidad;
    }
}
