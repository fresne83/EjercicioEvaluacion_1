package apartado2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import main.Menu;

/**
 * Clase para gestionar los alumnos de una lista. Se puede insetar un nuevo
 * alumno, eliminar un alumno a traves de su NIF, actualizar un alumno a traves
 * de su NIF,buscar alumnos dentro de la lista y listar los alumnos que hay en
 * la lista a traves de su fecha de nacimiento.
 *
 * @author Roberto
 */
public class GestorAlumno {

    private static GestorAlumno INSTANCE = null;
    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    private Alumno alumno;

    private GestorAlumno() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GestorAlumno();
        }
    }

    public static GestorAlumno getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    /**
     * Metodo para insertar nuevo alumno a la lista.
     *
     * @param nombre
     * @param nif
     * @param fecha
     * @throws java.lang.Exception
     */
    public final void nuevoAlumno(String nombre, String nif, LocalDate fecha) throws Exception {

        listaAlumnos.forEach((buscado) -> {
            if (!buscado.getNif().equals(nif)) {
                new Exception("NIF ya existe");
            } else {
                listaAlumnos.add(new Alumno(nombre, nif, fecha));
            }
        });
    }

    /**
     * Metodo para eliminar un alumno de la lista mediante su NIF.
     *
     * @param nif
     */
    public final void eliminarAlumnoNif(String nif) {
        Alumno eliminar = buscarAlumno(nif);
        listaAlumnos.remove(eliminar);
    }

    /**
     * Metodo para actualizar los datos de un alumno, a traves de su NIF.
     *
     * @param nif
     * @return el alumno actualizado.
     */
    public final Alumno actualizarAlumno(String nif) throws Exception {
        Alumno actualizar = buscarAlumno(nif);
        actualizar.setNombre(Menu.leerNombre());
        actualizar.setFechaNacimiento(Menu.leerFecha());
        return actualizar;
    }

    /**
     * Metodo para buscar un alumno detro de la lista.
     *
     * @param nif
     * @return Imprime el resultado y retorna el alumno buscado.
     */
    public final Alumno buscarAlumno(String nif) {
        Alumno resultado = null;
        for (Alumno buscado : listaAlumnos) {
            if (buscado.getNif().equals(nif)) {
                resultado = buscado;
            } else {
                new Exception("El NIF introducido no existe");
            }
        }
        System.out.println(resultado);
        return resultado;
    }

    /**
     * Metodo para listar los alumnos con una determinada fecha de nacimiento.
     *
     * @param fecha
     * @return Imprime una lista con los alumnos que coinciden y retorna una
     * lista con los alumnos.
     */
    public final ArrayList<Alumno> listarAlumnos(String fecha) {
        Alumno resultado = null;
        ArrayList<Alumno> temp = new ArrayList<>();
        for (Alumno buscado : listaAlumnos) {
            if (buscado.getFechaNacimiento().equals(LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE))) {
                resultado = buscado;
                temp.add(resultado);
            }
        }
        System.out.println(temp);
        return temp;
    }

    @Override
    public final String toString() {
        return listaAlumnos.toString();
    }

}
