package com.company.Generics;

import java.util.ArrayDeque;

public class Jar<E> {
    public ArrayDeque<E> elements;

    public Jar(ArrayDeque<E> elements) {
        this.elements = new ArrayDeque<>();
    }

    public void add(E element) {
        elements.push(element);
    }

    public E remove() {
        return elements.pop();
    }
}
