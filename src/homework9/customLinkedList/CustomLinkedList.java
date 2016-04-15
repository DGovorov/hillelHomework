package homework9.customLinkedList;

import java.util.Iterator;

/**
 * Created by User on 22.03.2016.
 */
public class CustomLinkedList implements MyList {

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
        if (next == null || index < 0) {
            throw new IndexOutOfBoundsException("size: " + size() + " index: " + index);
        } else {
            try {
                return next.get(index);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("size: " + size() + " index: " + index);
            }
        }
    }

    public boolean contains(Object obj) {
            return next != null && next.contains(obj);
    }

    public boolean remove(Object obj) {
        if (next == null) {
            return false;
        } else {
            if (obj.equals(next.getValue())) {
                next = next.getNext();
                return true;
            } else {
                return next.remove(obj);
            }
        }
    }

    public boolean remove(int index) {
        if (index < 0 || next == null) {
            throw new IndexOutOfBoundsException("size: " + size() + " index: " + index);
        }
        if (index == 0) {
            next = next.getNext();
            return true;
        } else {
            try {
                return next.remove(index - 1);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException("size: " + size() + " index: " + index);
            }
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