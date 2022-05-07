package rabbits;

import java.util.*;
import java.util.stream.Collectors;

public class Santa {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(materials::push);
        ArrayDeque<Integer> levels = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // opashka

        Map<String, Integer> map = new TreeMap<>();


        while (!materials.isEmpty() && !levels.isEmpty()) {
            int firstNumber = levels.peek();
            int lastNumber = materials.peek();
            int sum = firstNumber * lastNumber;

            switch (sum) {
                case 150:
                    if (!map.containsKey("Doll")) {
                        map.put("Doll", 1);
                    } else {
                        map.put("Doll", map.get("Doll") + 1);
                    }
                    levels.poll();
                    materials.pop();
                    break;
                case 250:
                    if (!map.containsKey("Wooden train")) {
                        map.put("Wooden train", 1);
                    } else {
                        map.put("Wooden train", map.get("Wooden train") + 1);
                    }
                    levels.poll();
                    materials.pop();
                    break;
                case 300:
                    if (!map.containsKey("Teddy bear")) {
                        map.put("Teddy bear", 1);
                    } else {
                        map.put("Teddy bear", map.get("Teddy bear") + 1);
                    }
                    levels.poll();
                    materials.pop();
                    break;
                case 400:
                    if (!map.containsKey("Bicycle")) {
                        map.put("Bicycle", 1);
                    } else {
                        map.put("Bicycle", map.get("Bicycle") + 1);
                    }
                    levels.poll();
                    materials.pop();
                    break;
                default:
                    if (sum < 0) {
                        levels.poll();
                        materials.pop();
                        materials.push(firstNumber + lastNumber);
                    } else if (sum > 0) {
                        levels.poll();
                        materials.pop();
                        materials.push(lastNumber + 15);
                    } else {
                        if (firstNumber == 0) {
                            levels.poll();
                        }
                        if (lastNumber == 0) {
                            materials.pop();
                        }
                    }
                    break;
            }
        }
        // a doll and a train or a teddy bear and a bicycle.
        boolean isDone = false;
        if (map.containsKey("Doll") && map.containsKey("Wooden train") || map.containsKey("Teddy bear") && map.containsKey("Bicycle")) {
            isDone = true;
        }
        if (isDone) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            while (!materials.isEmpty()) {
                if (materials.size() == 1) {
                    System.out.print(materials.pop());
                    break;
                }
                System.out.print(materials.pop() + ", ");
            }
        }
        if (!levels.isEmpty()) {
            System.out.print("Magic left: ");
            while (!levels.isEmpty()) {
                if (levels.size() == 1) {
                    System.out.print(levels.poll());
                    break;
                }
                System.out.print(levels.poll() + ", ");
            }
        }
        System.out.println();
        map.entrySet().forEach(e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
        });
    }
}
