import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<E> implements Iterable<E>, Iterator<E> {
    private int size = 0;
    private int cursor = 0;
    private int increment;
    private Object[] array;

    public MyList(int capacity, int increment) {
        this.increment = increment ;
        this.array = new Object[capacity];
    }

    public MyList(int capacity) {
        this(capacity, 5);
    }

    public MyList() {
        this(10);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public int increment() {
        return increment;
    }

    public void add(E n) {
        if (size < capacity()) {
            array[size] = n;
            size += 1;
        }
    }

    public void addHead(E n) {
        if (size < capacity()) {
            for (int i = size; i > 0; i--) {
                array[i] = array[i - 1];
            }

            array[0] = n;
            size += 1;
        }
    }

    public void remove() {
        if (size != 0) {
            size -= 1;
        }
    }

    public void removeTail() {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                array[i] = array[i + 1];
            }

            size -= 1;
        }
    }

    @Override
    public Iterator<E> iterator() {
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

