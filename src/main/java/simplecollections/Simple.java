package simplecollections;

import java.util.Iterator;

public interface Simple<E> extends Iterator<E> {
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index, E e);
}
