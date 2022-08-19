package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Function<String, Double> map = arr -> Double.parseDouble(arr) * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scan.nextLine().split(", "))
                .map(map).forEach(e -> System.out.printf("%.2f%n", e));


    }
}
