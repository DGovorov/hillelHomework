package homework9.custom_linked_list;

/**
 * Created by Dim on 31.03.2016.
 */
public interface Improved {

    void add(Object value);

    Object get(int index);

    int size();

    boolean contains(Object value);

    void remove(int index);

    void remove(Object value);
}
