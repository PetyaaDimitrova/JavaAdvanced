package Exam_19August;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> effects = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // opashka

        ArrayDeque<Integer> casings = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(casings::push);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Cherry Bombs", 0);
        map.put("Datura Bombs", 0);
        map.put("Smoke Decoy Bombs", 0);

        int cherry = 0;
        int datura = 0;
        int smoke = 0;

        boolean isReady = false;

        while (!effects.isEmpty() && !casings.isEmpty()) {
            int effectsNumber = effects.peek();
            int casingNumber = casings.peek();

            int sum = effectsNumber + casingNumber;

            switch (sum) {
                case 60:
                    effects.poll();
                    casings.pop();
                    map.put("Cherry Bombs", map.get("Cherry Bombs") +1);
                    cherry++;
                    break;
                case 40:
                    effects.poll();
                    casings.pop();
                    map.put("Datura Bombs", map.get("Datura Bombs") + 1);
                    datura++;
                    break;
                case 120:
                    effects.poll();
                    casings.pop();
                    map.put("Smoke Decoy Bombs", map.get("Smoke Decoy Bombs") + 1);
                    smoke++;
                    break;
                default:
                    casings.pop();
                    casings.push(casingNumber - 5);
                    break;
            }
            if(smoke >= 3 && datura >=3 && cherry >= 3){
                System.out.println("Bene! You have successfully filled the bomb pouch!");
              printResult(effects,casings, map);
              return;
            }


        }
        System.out.println("You don't have enough materials to fill the bomb pouch.");
        printResult(effects,casings, map);

    }

    private static void printResult(ArrayDeque<Integer> effects, ArrayDeque<Integer> casings, Map<String, Integer> map) {


        System.out.println("Bomb Effects: " + getElementsInfo(effects));
        System.out.println("Bomb Casings: " + getElementsInfo(casings));

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "empty" : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

}
