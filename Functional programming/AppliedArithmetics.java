package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = e -> Arrays.stream(e).map(el -> el += 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(e -> e = e * 2).toArray();
        Function < int[],int[]> subtract = arr -> Arrays.stream(arr).map(e-> e-=1).toArray();
        Consumer<int[]> print = e->Arrays.stream(e).forEach(el -> System.out.print(el + " "));

        String command = scan.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scan.nextLine();
        }

    }
}
