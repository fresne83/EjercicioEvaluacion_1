
package apartado1;

import java.util.ArrayList;
import java.util.List;

/**
 * La siguiente clase permite crear objetos que contienen una lista de strings.
 * @author Roberto
 */
public class ListaItems {

    private List<String> items;

    public ListaItems() {
        items = new ArrayList<String>();
    }

    public void add(String item) {
        items.add(item);
    }
}

