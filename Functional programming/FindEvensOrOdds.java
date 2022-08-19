package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int startNumber = 0;
        int endNumber = 0;
        int a = numbers[0];
        int b = numbers[1];
        if (a > b) {
            startNumber = b;
            endNumber = a;
        } else {
            startNumber = a;
            endNumber = b;
        }
        String condition = scan.nextLine();
        switch (condition) {
            case "odd":
                Predicate<Integer> isOdd = n -> n % 2 == 1 || n % 2 == -1;
                for (int i = startNumber; i <= endNumber; i++) {
                    boolean isOddNumber = isOdd.test(i);
                    if (isOddNumber) {
                        System.out.print(i + " ");
                    }
                }
                break;
            case "even":
                Predicate<Integer> isEven = n -> n % 2 == 0;
                for (int i = startNumber; i <= endNumber; i++) {
                    boolean isEvenNumber = isEven.test(i);
                    if (isEvenNumber) {
                        System.out.print(i + " ");
                    }
                }
                break;
        }


    }
}
