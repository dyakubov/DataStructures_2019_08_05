package ru.geekbrains.datastructure.lesson2.array;

import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 16;

    protected E[] data;
    protected int size;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    //O(1) ~ O(N)
    @Override
    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Not null value is required");
        }
        checkGrow();
        data[size++] = value;
    }

    protected void checkGrow() {
        if (size == data.length) {
            data = grow();
        }
    }

    private E[] grow() {
        return Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public boolean remove(E value) {
        return remove(indexOf(value));
    }

    //the best: O(1)
    //the bad: O(N-1) => O(N)
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
        return true;
    }

    //O(1)
    @Override
    public E get(int index) {
        if (index > 0 && index < size) {
            return data[index];
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    //O(N)
    @Override
    public int indexOf(E value) {
        if (value == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
        System.out.println("--------");
    }

    //O(N^2)
    //compare: N * N = N^2
    //swap: N * N = N^2
    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    //O(N^2)
    //compare: N * N = N^2
    //swap: N
    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }
}
