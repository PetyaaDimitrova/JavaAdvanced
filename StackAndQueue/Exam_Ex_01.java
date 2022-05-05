package Exam_19August;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exam_Ex_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // opashka

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int malesNumber = males.peek();
            int femalesNumber = females.peek();

            if(malesNumber <=0){
                males.pop();
                continue;
            }
            if(femalesNumber <=0){
                females.poll();
                continue;
            }
            if(malesNumber % 25 == 0){
                males.pop();
                males.pop();
                continue;
            }
            if(femalesNumber % 25 == 0){
                females.poll();
                females.poll();
                continue;
            }


            if(malesNumber == femalesNumber){
                matches++;
            }
            females.poll();
            males.pop();
            if (malesNumber != femalesNumber) {
                males.push(malesNumber - 2);
            }
        }

        System.out.printf("Matches: %d%n", matches);
        System.out.println("Males left: " + getElementsInfo(males));
        System.out.println("Females left: " + getElementsInfo(females));
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "none" : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
