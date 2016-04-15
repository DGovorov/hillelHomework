package homework9.customLinkedList;

/**
 * Created by Dim on 31.03.2016.
 */
public interface MyList extends Iterable {

    void add(Object value);

    Object get(int index);

    int size();

    boolean contains(Object value);

    boolean remove(int index);

    boolean remove(Object value);
}
