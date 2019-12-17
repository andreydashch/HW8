package simplecollections.arraylist;

import java.util.Iterator;

public interface SimpleArray<E> extends Iterable<E> {
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index, E e);
}
