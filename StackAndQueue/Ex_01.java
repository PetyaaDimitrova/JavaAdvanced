package Exam_19August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // opashka

        int bouquets = 0;
        int storedFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int liliesNumber = lilies.peek();
            int rosesNumber = roses.peek();
            int sum = liliesNumber + rosesNumber;

            if (sum == 15) {
                bouquets++;
                lilies.pop();
                roses.poll();
            } else if (sum > 15) {
                int liliesValue = lilies.pop();

                lilies.push(liliesValue - 2);
            } else {
                storedFlowers += lilies.pop();
                storedFlowers += roses.poll();
            }
        }
        int stored = storedFlowers / 15;
        bouquets += stored;

        if (bouquets >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", bouquets);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - bouquets);
        }

    }
}
