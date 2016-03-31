package homework9.custom_linked_list;


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
                return null;
            }
            return next.get(index - 1);
        }
    }

    public boolean contains(Object obj) {
        if (obj.equals(getValue())) {
            return true;
        } else {
            if (next == null) {
                return false;
            } else {
                return next.contains(obj);
            }
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
        if (next == null) {
            if (index > 0) {
                System.out.println("index out of list size");
            }
            return;
        }
        if (index == 0) {
            next = next.getNext();
        } else {
            next.remove(index - 1);
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