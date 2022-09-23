package com.company.Iterators;

public class Main {
    public static void main(String[] args) {
        SmartArray<Integer> smartArray = new SmartArray<>(5);
        smartArray.add(0,0);
        smartArray.add(1,1);
        smartArray.add(2,2);
        smartArray.add(3,3);
        smartArray.add(4,4);


        for (int i:smartArray
             ) {
            System.out.println(smartArray.get(i));
        }
    }
}
