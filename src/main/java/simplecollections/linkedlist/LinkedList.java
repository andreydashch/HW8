package simplecollections.linkedlist;

import java.util.Iterator;

public class LinkedList<E> implements SimpleLinked<E>, Iterable<E>, DescendingIterator<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        this.head = new Node<>(null, null, null);
        this.tail = new Node<>(null, head, null);

        this.head.setNext(tail);
    }

    public static void main(String[] args) {
        LinkedList<String> strings= new LinkedList<>();

        strings.addFirst("first");
        strings.addFirst("zero");
        strings.addLast("second");
        strings.addLast("third");

        strings.dell(strings.size - 2);

        for (int i=0;i <= strings.size - 1;i++) {
            System.out.println(strings.get(i));
        }

        for (String string : strings) {
            System.out.println(string);
        }

        Iterator<String> descending = strings.descendingIterator();

        while(descending.hasNext()) {
            System.out.println(descending.next());
        }

    }

    @Override
    public void addFirst(E e) {
        Node<E> added = new Node<>(e, head, head.next);

        head.next.setPrevious(added);
        head.setNext(added);

        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> added = new Node<>(e, tail.previous, tail);

        tail.previous.setNext(added);
        tail.setPrevious(added);

        size++;
    }

    @Override
    public void dell(int index) {
        Node<E> node = findNode(index);

        node.previous.setNext(node.next);
        node.next.setPrevious(node.previous);

        size--;
    }

    @Override
    public E get(int index) {
        return findNode(index).current;
    }

    private Node<E> findNode(int index) {
        Node<E> searched = head;

        for (int i=0;i <= index;i++) {
            searched = searched.next;
        }
        return searched;
    }


    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;


            @Override
            public boolean hasNext() {
                return index <= size - 1;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int index = size - 1;


            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return get(index--);
            }
        };
    }


    private static class Node<T> {
        T current;
        Node<T> previous;
        Node<T> next;

        public Node(T current, Node<T> previous, Node<T> next) {
            this.current = current;
            this.next = next;
            this.previous = previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
