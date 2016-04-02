package homework9.custom_linked_list;

import java.util.Iterator;

/**
 * Created by User on 22.03.2016.
 */
public class CustomLinkedList implements Improved, Iterable {

    private ListElement next;

    public int size() {
        if (next == null) {
            return 0;
        } else {
            return next.size();
        }
    }

    public void add(Object o) {
        if (next == null) {
            next = new ListElement(o);
        } else {
            next.add(o);
        }
    }

    public Object get(int index) {
        if (next == null) {
            return null;
        } else {
            return next.get(index);
        }
    }

    public boolean contains(Object obj) {
        if (next == null) {
            return false;
        } else {
            return next.contains(obj);
        }
    }

    public void remove(Object obj) {
        if (next == null) {
            return;
        } else {
            if (obj.equals(next.getValue())) {
                next = next.getNext();
            } else {
                next.remove(obj);
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || next == null) {
            return;
        }
        if (index == 0) {
            next = next.getNext();
        } else {
            next.remove(index - 1);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomLinkedList)) {
            return false;
        }
        CustomLinkedList other = (CustomLinkedList) obj;

        if (size() != other.size()) {
            return false;
        }

        Iterator thisIterator = iterator();
        Iterator otherIterator = other.iterator();
        while (thisIterator.hasNext()) {
            if (!(thisIterator.next().equals(otherIterator.next()))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        if (next == null) {
            return "LinkedList is empty";
        } else {
            return next.toString();
        }
    }

    @Override
    public Iterator iterator() {
        return new CustomLinkedListIterator(next);
    }
}