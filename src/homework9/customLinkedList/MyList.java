package homework9.customLinkedList;

/**
 * Created by Dim on 31.03.2016.
 */
public interface MyList extends Iterable {

    void add(Object value);

    Object get(int index);

    int size();

    boolean contains(Object value);

    void remove(int index);

    void remove(Object value);
}
