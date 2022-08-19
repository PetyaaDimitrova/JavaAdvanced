package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallest {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> findMinNumber = e -> {
            int minNumber = Integer.MAX_VALUE;
            for (int n: e
            ) {
                if(n<minNumber){
                    minNumber = n;
                }
            }
            System.out.println(e.lastIndexOf(minNumber));
        };

        findMinNumber.accept(numbers);

    }
}
