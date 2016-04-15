package homework9.customLinkedList;


/**
 * Created by User on 22.03.2016.
 */
public class ListElement {

    private Object value;
    private ListElement next;

    public ListElement(Object value) {
        this.value = value;
    }

    public int size() {
        if (next == null) {
            return 1;
        } else {
            return next.size() + 1;
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
        if (index == 0) {
            return value;
        } else {
            if (next == null) {
                throw new IndexOutOfBoundsException();
            }
            return next.get(index - 1);
        }
    }

    public boolean contains(Object obj) {
        return obj.equals(getValue()) || next != null && next.contains(obj);
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
        if (next == null && index >= 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            next = next.getNext();
            return true;
        } else {
            return next.remove(index - 1);
        }
    }

    public Object getValue() {
        return value;
    }

    public ListElement getNext() {
        return next;
    }

    public String toString() {
        if (next == null) {
            return getValue() + ".";
        } else {
            return getValue().toString() + ", " + next.toString();
        }
    }
}