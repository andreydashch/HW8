package simplecollections.arraylist;

import java.util.Iterator;

public class ArrayList<E> implements SimpleArray<E> {
    private E[] values;

    public static void main(String[] args) {
        SimpleArray<String> strings = new ArrayList<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");

        strings.update(0,"firstUpdated");
        strings.delete(2);

        for (int index=0;index <= strings.size() - 1;index++) {
            System.out.println(strings.get(index));
        }

        for (String string : strings){
            System.out.println(string);
        }
    }

    public ArrayList() {
        this.values = (E[]) new Object[0];
    }

    public boolean add(E e) {
        E[] temp = values;

        try {
            values = (E[]) new Object[values.length + 1];
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return false;
        }

        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;

        return true;
    }

    public void delete(int index) {
        E[] temp = values;

        try {
            values = (E[]) new Object[values.length - 1];
        } catch (ClassCastException ex) {
            ex.printStackTrace();

            return;
        }

        System.arraycopy(temp, 0, values, 0, index);

        if(index != temp.length - 1) {
            System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
        }
    }

    public E get(int index) {
        return values[index];
    }

    public int size() {
        return values.length;
    }

    public void update(int index, E e) {
        values[index] = e;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
