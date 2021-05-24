package com.interview.basic.data_structures.vectors_arraylists;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;

    public ArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
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
    public E get(int i) throws IndexOutOfBoundsException {
        checkBoundary(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkBoundary(i, size);
        data[i] = e;
        return e;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkBoundary(i, size + 1);
        if (size == data.length) {
            data = resize(2 * size);
        }
        System.arraycopy(data, i, data, i + 1, size - i);
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkBoundary(i, size);
        E result = data[i];
        System.arraycopy(data, i + 1, data, i, size - i - 1);
        data[size - 1] = null;
        size--;
        return result;
    }

    private void checkBoundary(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
    }

    private E[] resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        return newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
