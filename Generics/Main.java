package com.company.Generics;

public class Main {
    public static void main(String[] args) {

        Pickle pickle = new Pickle("green");
        JarOfPickles jar = new JarOfPickles();
        jar.add(pickle);
        System.out.println(jar.remove().color);
    }
}
