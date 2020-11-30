package Pack1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyDec<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    // 0 1 2 3 4
    // 7 5
    // b
    //     e

    public MyDec(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDec() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }
    public T peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[end];
    }

    public T removeRight() {
        T temp = peekRight();
        size--;
        list[end] = null;
        end = beforeIndex(end);
        return temp;
    }
    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        size++;
        begin = beforeIndex(begin);
        list[begin] = item;
    }
    public void insertRight(T item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        size++;
        end = nextIndex(end);  // end указывает не на пустую ячейку справа, а на последнюю заполненную
        list[end] = item;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int beforeIndex (int index){
        if(index==0){
            return list.length-1;
        }else {
            return index-1;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " begin: " + begin + " end: " + end;
    }
}
