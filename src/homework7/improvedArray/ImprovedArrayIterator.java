package homework7.improvedArray;

import java.util.Iterator;

/**
 * Created by Dim on 12.04.2016.
 */
public class ImprovedArrayIterator implements Iterator {

    private ImprovedArray array;
    private int currentIndex = 0;

    public ImprovedArrayIterator(ImprovedArray array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.size();
    }

    @Override
    public Object next() {
        Object current = array.get(currentIndex);
        currentIndex++;
        return current;
    }

    @Override
    public void remove() {
        if (currentIndex != 0) {
            currentIndex--;
        }
        array.remove(currentIndex);
    }
}
