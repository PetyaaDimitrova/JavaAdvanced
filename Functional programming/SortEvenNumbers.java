package FunctionalProgramming;


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        String output  = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);

        String sorted = Arrays.stream(numbers)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(sorted);

    }
}
