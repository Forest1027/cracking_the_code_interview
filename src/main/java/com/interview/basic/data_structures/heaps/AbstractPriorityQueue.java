package com.interview.basic.data_structures.heaps;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }

    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // implementation for Entry
    protected static class PQEntry<K, V> implements Entry<K, V> {

        private K k;
        private V v;

        public PQEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        public void setK(K k) {
            this.k = k;
        }

        public void setV(V v) {
            this.v = v;
        }
    }
}
