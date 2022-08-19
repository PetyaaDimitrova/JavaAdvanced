package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        BiFunction<Integer, Integer, Boolean> isDivisible = (x, y) -> x % y == 0;

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int j = 1; j <= n; j++) {
            int times = 0;
            for (int i = 0; i < numbers.length; i++) {
                int number = numbers[i];

                boolean isOk = isDivisible.apply(j, number);
                if (isOk) {
                    times++;
                    if (times == numbers.length) {
                        System.out.print(j + " ");
                    }
                }
            }
        }
    }
}
