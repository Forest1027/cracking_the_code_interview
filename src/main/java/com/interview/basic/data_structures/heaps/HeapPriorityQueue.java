package com.interview.basic.data_structures.heaps;

import com.interview.basic.data_structures.vectors_arraylists.ArrayList;

import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        int index = size();
        Entry<K, V> entry = new PQEntry<>(key, value);
        heap.add(index, entry);
        upheap(index);
        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> entry = min();
        swap(0, size() - 1);
        heap.remove(size() - 1);
        downheap(0);
        return entry;
    }

    // utilities
    private int parent(int j) {
        return (j - 1) / 2;
    }

    private int left(int j) {
        return 2 * j + 1;
    }

    private int right(int j) {
        return 2 * j + 2;
    }

    private boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    private boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    private void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void upheap(int j) {
        int parent = parent(j);
        while (j > 0 && compare(heap.get(j), heap.get(parent)) < 0) {
            swap(j, parent);
            j = parent;
            parent = parent(j);
        }
    }

    private void downheap(int j) {
        while (j < heap.size()) {
            int smallerIndex = j;
            if (hasLeft(j) && compare(heap.get(j), heap.get(left(j))) > 0) {
                smallerIndex = left(j);
            }

            if (hasRight(j) && compare(heap.get(smallerIndex), heap.get(right(j))) > 0) {
                smallerIndex = right(j);
            }

            if (smallerIndex == j) {
                break;
            } else {
                swap(j, smallerIndex);
                j = smallerIndex;
            }
        }
    }

}
