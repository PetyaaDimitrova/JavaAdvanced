package com.company.Iterators;

import java.util.Iterator;

public class SmartArray<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    public SmartArray(Object[] data, int size) {
        this.data = new Object[10];
        this.size = size;
    }

    @Override
    public Iterator<E> iterator() {
        return new SmartArrayIterator();
    }


    public class SmartArrayIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
