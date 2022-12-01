package acardenas.com.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class JugadorTenis {

    protected Integer id;

    @NotBlank
    private String nombre;

    @Size(max = 100)
    private Integer nivelHabilidad;

    private static int ultimoId;

    public JugadorTenis( String nombre, Integer nivelHabilidad) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.nivelHabilidad = nivelHabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivelHabilidad() {
        return nivelHabilidad;
    }

    public void setNivelHabilidad(Integer nivelHabilidad) {
        this.nivelHabilidad = nivelHabilidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorTenis that = (JugadorTenis) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
