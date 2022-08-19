package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> predicate = e -> e % n == 0;

        numbers.removeIf(predicate);

        Consumer<List<Integer>> consumer = arr -> arr.forEach(el -> System.out.print(el + " "));

        consumer.accept(numbers);

    }
}
