package main;

import apartado1.ListaItems1;

/**
 * Aplicacion para gestionar una lista de registro de alumnos.
 *
 * @author Roberto
 */
public class Programa {

    public static void main(String[] args) throws Exception {
//        boolean fin = false;
//        do {
//            Menu.mostrarMenu();
//            int opcion = Menu.seleccionarOpcion();
//            fin = Menu.ejecutarOpcion(opcion);
//        } while (!fin);
        ListaItems1 lista = new ListaItems1();
        lista.add('a');
        lista.add('b');
        lista.add('a');
        lista.add('r');
        lista.select('a');
        lista.aplana();
        lista.add('c');
        lista.agrupa();
    }
}
