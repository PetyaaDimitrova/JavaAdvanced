package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpperCase {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Predicate<String> predicate = e -> Character.isUpperCase(e.charAt(0));

        String[] tokens = Arrays.stream(scan.nextLine().split(" ")).filter(predicate).toArray(String[]::new);

        System.out.println(tokens.length);

        Arrays.stream(tokens).forEach(e -> System.out.printf("%s%n", e));


    }
}
