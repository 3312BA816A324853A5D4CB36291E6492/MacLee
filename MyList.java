import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<E> {
    private int capacity = 10;
    private int size = 0;
    private Object[] array;

    public MyList() {
        this.array = new Object[capacity];
    }

    public void add(E n) {
        if (size < capacity) {
            array[size] = n;
            size += 1;
        }
    }

    public Iterator<E> iterator() {
        return new MyList.Itr();
    }

    private class Itr implements Iterable<E>, Iterator<E> {
        int cursor = 0;

        @Override
        public Iterator iterator() {
            cursor = 0;
            return this;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                return (E) array[cursor++];
            }
            throw new NoSuchElementException();
        }
    }
}

