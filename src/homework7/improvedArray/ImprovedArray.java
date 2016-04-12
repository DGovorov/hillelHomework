package homework7.improvedArray;

import homework9.customLinkedList.MyList;

import java.util.Iterator;

/**
 * Created by Dim on 12.03.2016.
 */
public class ImprovedArray implements MyList {

    private Object[] elements = new Object[10];
    private int elementCounter;

    public void add(Object value) {
        if (elementCounter == elements.length) {
            resize();
        }
        elements[elementCounter] = value;
        elementCounter++;
    }

    private void resize() {
        Object[] temp = new Object[elementCounter * 2];
        System.arraycopy(elements, 0, temp, 0, elements.length);
        elements = temp;
    }

    public Object get(int index) {
        indexOutOfBoundsCheck("get()", index);
        return elements[index];

    }

/*    public void set(int index, Object obj) {
        if (index < 0 || index > size()) {
            System.out.println("ImprovedArray.set: invalid index");
            return;
        }
        elements[index] = obj;
    }*/

    public void swap(int firstElementIndex, int secondElementIndex) {
        indexOutOfBoundsCheck("swap()", firstElementIndex, secondElementIndex);
        Object temp = get(firstElementIndex);
        elements[firstElementIndex] = get(secondElementIndex);
        elements[secondElementIndex] = temp;
    }

    public int size() {
        return elementCounter;
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSorted(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return obj.equals(get(0));
        }

        int start = 0;
        int end = size() - 1;
        return seekOut(obj, start, end);
    }

    private boolean seekOut(Object obj, int start, int end) {
        if (end < start) {
            return false;
        }

        int index = (start + end) / 2;

        Comparable o = (Comparable) obj;
        Comparable arrayElement = (Comparable) get(index);

        if (o.equals(arrayElement)) {
            return true;
        }

        if (o.compareTo(arrayElement) < 0) {
            end = index - 1;
        } else {
            start = index + 1;
        }
        return seekOut(obj, start, end);

    }

    public void remove(int index) {
        indexOutOfBoundsCheck("remove()", index);
        System.arraycopy(elements, index + 1, elements, index, elements.length - 1 - index);
        elementCounter--;

    }

    public void remove(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(obj)) {
                remove(i);
                return;
            }
        }
    }

    private void indexOutOfBoundsCheck(String methodName, int... indexes) {
        for (int index : indexes) {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException(methodName + " called, size: " + size() + " index: " + index);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImprovedArray)) {
            return false;
        }
        ImprovedArray other = (ImprovedArray) o;

        if (size() != other.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "Array is empty";
        }

        String result = "";
        for (int i = 0; i < size(); i++) {
            result = result + "\'" + elements[i];
            if (i < elementCounter - 1) {
                result = result + "\', ";
            } else {
                result = result + "\'.";
            }
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new ImprovedArrayIterator(this);
    }
}