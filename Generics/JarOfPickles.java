package com.company.Generics;

import java.util.ArrayDeque;

public class JarOfPickles extends Jar<Pickle>{

    public JarOfPickles(ArrayDeque<Pickle> elements) {
        super(elements);
    }
}
