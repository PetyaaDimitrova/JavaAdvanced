package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class CustomMinFunction {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Consumer<int[]> consumer = a -> System.out.println(Arrays.stream(numbers).min().orElse(0));

        consumer.accept(numbers);

    }
}
