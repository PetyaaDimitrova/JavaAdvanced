package StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer>secondBox = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(secondBox::push);
        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int secondNumber = secondBox.pop();
            int firstNumber = firstBox.peek();
            int sum = secondNumber + firstNumber;
            if(sum%2 == 0){
                claimedItems.add(sum);
                firstBox.poll();
            } else {
                firstBox.offer(secondNumber);
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if(secondBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        int sum = 0;
        for (int n: claimedItems
        ) {
            sum += n;
        }
        if(sum >=90){
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
