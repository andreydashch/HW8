package simplecollections.linkedlist;

public interface SimpleLinked<E> {
    void addFirst(E e);
    void addLast(E e);
    void dell(int index);
    E get(int index);
}
