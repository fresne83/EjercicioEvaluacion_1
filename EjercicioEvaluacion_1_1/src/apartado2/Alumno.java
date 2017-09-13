package apartado2;

import java.time.LocalDate;
/**
 * Clase para crear las propiedades de los alumnos.
 * @author Roberto
 */
public class Alumno {

    private String nombre;
    private final String nif;
    private LocalDate fechaNacimiento;

    public Alumno(String nombre, String nif, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.nif = nif;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", nif=" + nif + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
}
