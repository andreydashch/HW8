package simplecillections.arraylist;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    E[] values;

    public boolean hasNext() {
        return index < values.length;
    }

    public E next() {
        return values[index++];
    }

    public void remove() {
        // Noting
    }

}
