package com.company.Iterators;

import java.util.Iterator;

public class SmartArray<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    public SmartArray(int size) {
        this.data = new Object[5];
        this.size = size;
    }

    public void add(E element, int index){
        this.data[index] = element;
    }

    @Override
    public Iterator<E> iterator() {
        return new SmartArrayIterator();
    }


    public class SmartArrayIterator implements Iterator<E> {

        private int i;

        @Override
        public boolean hasNext() {
            return i < data.length;
        }

        @Override
        public E next() {
            return get(i++);
        }
    }

    public E get(int index){
        return (E)this.data[index];
    }
}
