package apartado1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * CUESTIÓN 1.
 * Modifica la clase ListaItems para que sea genérica y permita adaptarla a
 * cualquier tipo de clase que sea una secuencia de caracteres.
 *
 * @author Roberto
 */
public class ListaItems1 {
    private final List<Character> items;
    public ListaItems1() {
        items = new ArrayList<>();
    }
    public void add(Character item) {
        items.add(item);
    }

/**
 * CUESTIÓN 2.
 * select(filtro)
 * @param filtro
 * @return lista de items que cumplan con la condición de filtro establecida por el parámetro.
 */
    public List<Character> select(Character filtro) {
        List<Character> temp = new ArrayList<>();
        items.stream().filter((item) -> (filtro.equals(items))).forEachOrdered((item) -> {
            temp.add(item);
        });
        System.out.println(temp);
        return temp;
    }
    
/**
 * CUESTIÓN 3.
 * aplana()
 * @return string formado por la concatenación de todos los items de la lista.
 * debe comenzar y finalizar con paréntesis, 
 * y en el medio de los paréntesis se debe mostrar cada ítem separado con un guion.
 */
    public String aplana() {
        StringBuilder temp = new StringBuilder();
        items.forEach((str) -> {
            temp.append(str).append('-');
        });
        System.out.println("("+temp.append(')'));
        return temp.toString();
        
    }
/**
 * CUESTIÓN 4. 
 * método agrupa() 
 * @return Map<Integer, List<String>>.
 * Agrupar los items por su longitud, de forma que el mapa retorne un elemento con la longitud como clave 
 * y una lista con los items como valor asociado a la clave.   
 */
    public Map<Integer, List<String>> agrupa(){
        Map<Integer, List<String>> mapa = new TreeMap<>();
        List<String> temp = new ArrayList<>();
        for(int i = 0; i<items.size();i++){
            temp.add(items.get(i).toString());// recorre items y sacamos cada caracter.
            mapa.put(items.get(i).toString().length(), temp);// Incluimos la longitud como clave y la lista con los items.
        }
        System.out.println(mapa.toString());//Previsualizacion de lo que contiene mapa.
        return mapa;
    }

    
}
