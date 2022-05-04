package Oct26;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);

        ArrayDeque<Integer> females = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); //opashka

        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {

            int firstNumber = females.peek();
            if (firstNumber <= 0) {
                females.poll();
                continue;
            }
            if (firstNumber % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }
            int secondNumber = males.peek();
            if (secondNumber <= 0) {
                males.pop();
                continue;
            }
            if (secondNumber % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (firstNumber == secondNumber) {
                matches++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                males.pop();
                males.push(secondNumber - 2);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        System.out.print("Males left: ");
        if (males.isEmpty()) {
            System.out.print("none");
        } else {
            while (!males.isEmpty()) {
                if (males.size() == 1) {
                    System.out.printf("%s", males.pop());
                    break;
                }
                System.out.printf("%s, ", males.pop());
            }
        }
        System.out.println();
        System.out.print("Females left: ");
        if (females.isEmpty()) {
            System.out.print("none");
        } else {
            while (!females.isEmpty()) {
                if (females.size() == 1) {
                    System.out.printf("%s", females.poll());
                    break;
                }
                System.out.printf("%s, ", females.poll());
            }
        }
    }
}
