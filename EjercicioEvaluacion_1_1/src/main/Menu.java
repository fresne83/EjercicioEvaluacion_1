package main;

import apartado2.GestorAlumno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase Menu del programa encargada de mostrar al usuario las diferentes
 * opciones dentro del programa.
 * @author Roberto
 */
public class Menu {

    public static GestorAlumno nAlumno = GestorAlumno.getInstance();
    private static final String MENU_OPCIONES = "MENU: \n"
            + "--------------\n"
            + "1- Insertar alumno nuevo.\n"
            + "2- Eliminar alumno(NIF).\n"
            + "3- Actualizar datos de un alumno.\n"
            + "4- Obtener datos de alumno(NIF).\n"
            + "5- Obtener listado de alumnos.\n"
            + "6- Salir.\n";
    private static final String OPCION = "Introduzca una opción:";
    private static final int NUEVO_ALUMNO = 1;
    private static final int ELIMINAR_ALUMNO = 2;
    private static final int ACTUALIZAR_DATOS = 3;
    private static final int OBTENER_DATOS = 4;
    private static final int OBTENER_LISTA = 5;
    private static final int SALIR = 6;
    private static final String FIN = "Fin del programa.";
    public static final String NOMBRE = "Introduzca nombre de Alumno: ";
    public static final String NIF = "Introduzca NIF: ";
    public static final String FECHA = "Introduzca una fecha (AAAA-MM-DD): ";

    static void mostrarMenu() {
        System.out.println();
        System.out.println(MENU_OPCIONES);
    }
    static int seleccionarOpcion() {
        System.out.println(OPCION);
        return leerEntero();
    }
    static boolean ejecutarOpcion(int opcion) throws Exception {

        switch (opcion) {
            case NUEVO_ALUMNO:
                nAlumno.nuevoAlumno(leerNombre(), leerNif(), leerFecha());
                break;
            case ELIMINAR_ALUMNO:
                nAlumno.eliminarAlumnoNif(leerNif());
                break;
            case ACTUALIZAR_DATOS:
                nAlumno.actualizarAlumno(leerNif());
                break;
            case OBTENER_DATOS:
                nAlumno.buscarAlumno(leerNif());
                break;
            case OBTENER_LISTA:
                nAlumno.listarAlumnos(leerFecha().toString());
                break;
            case SALIR:
                System.out.println(FIN);
                return true;
        }
        return false;
    }

    public static String leerNombre() {
        System.out.println(NOMBRE);
        return new Scanner(System.in).nextLine();
    }
    public static String leerNif() {
        System.out.println(NIF);
        return new Scanner(System.in).nextLine();
    }
    public static int leerEntero() {
        return new Scanner(System.in).nextInt();
    }
    public static LocalDate leerFecha() throws Exception{
        System.out.println(FECHA);
        String fecha = new Scanner(System.in).nextLine();
        LocalDate f1 = null;
        try {
            f1 = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
        } catch (Exception e) {
            System.out.println("Fecha no valida");
        }
        return f1;
    }
}
