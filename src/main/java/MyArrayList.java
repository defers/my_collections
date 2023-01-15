import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private final int INCREASE_FACTOR = 2;
    private int capacity;
    private int size;
    private Object[] elementData;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++) {
            E e = (E) elementData[i];
            if (e != null && e.equals((E) o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null; //TODO
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length <= this.size) {
            return (T[]) Arrays.copyOf(this.elementData, this.size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, this.size);
        return a;
    }

    @Override
    public boolean add(E e) {
        int index = this.size;
        add(index, e);
        return true;
    }

    private void raiseArray(int numberOfNewElements) {
        if (this.size + numberOfNewElements >= this.capacity) {
            this.capacity = this.capacity * this.INCREASE_FACTOR;
            this.elementData = Arrays.copyOf(this.elementData, this.capacity);
        }
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.size; i++) {
            E e = (E) this.elementData[i];
            if (e.equals((E) o)) {
                removeElement(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false; //TODO
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false; //TODO
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false; //TODO
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false; //TODO
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false; //TODO
    }

    @Override
    public void clear() {
        for(int i = 0; i <= this.size+1; i++) {
            removeElement(i);
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    private void checkIndex(int index, int numberNewElements) {
        if (index >= this.size + numberNewElements) {
            throw new IndexOutOfBoundsException("Index is out of range of the list");
        }
    }

    private void checkIndex(int index) {
        this.checkIndex(index, 0);
    }

    private void setElement(int index, E element) {
        this.elementData[index] = element;
    }

    private void addElement(int index, E element) {
        this.elementData[index] = element;
        this.size++;
    }

    private E removeElement(int index) {
        E e = (E) elementData[index];
        elementData[index] = null;
        shiftElementsLeft(index);
        this.size--;
        return e;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        setElement(index, element);
        return element;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index, 1);
        raiseArray(1);
        shiftElementsRight(index);
        addElement(index, element);
    }

    private void shiftElementsRight(int startPosition) {
        for (int i = this.size - 1; i >= startPosition; i--) {
            this.elementData[i+1] = this.elementData[i];
            this.elementData[i] = null;
        }
    }

    private void shiftElementsLeft(int startPosition) {
        for (int i = startPosition; i < this.size - 1; i++) {
            this.elementData[i] = this.elementData[i+1];
            this.elementData[i+1] = null;
        }
    }
    @Override
    public E remove(int index) {
        checkIndex(index);
        E e = removeElement(index);
        return e;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            E e = (E) this.elementData[i];
            if (e.equals((E) o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0; //TODO
    }

    @Override
    public ListIterator<E> listIterator() {
        return null; //TODO
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null; //TODO
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null; //TODO
    }
}
