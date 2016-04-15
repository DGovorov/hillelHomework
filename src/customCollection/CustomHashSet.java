package customCollection;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by Dim on 14.04.2016.
 */
public class CustomHashSet {

    private LinkedList[] elements = new LinkedList[10];
    private int loadFactor;

    public void add(Object value) {
        int index = value.hashCode() % elements.length;

        if (elements[index] != null && !elements[index].isEmpty()) {
            elements[index].add(value);
        }
    }


    public void remove(int index) {

    }

    public void remove(Object obj) {

    }

    public boolean contains(Object obj) {
        return false;
    }

    public int size() {
        return elements.length;
    }
}
