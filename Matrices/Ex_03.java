package Dec16;

import java.util.*;
import java.util.stream.Collectors;

public class Ex_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Biscuit", 0);
        map.put("Cake", 0);
        map.put("Pie", 0);
        map.put("Pastry", 0);


        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquidNumber = liquids.peek();
            int ingredientNumber = ingredients.peek();

            int sum = liquidNumber + ingredientNumber;
            switch (sum){
                case 25:
                    map.put("Biscuit", map.get("Biscuit") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 50:
                    map.put("Cake", map.get("Cake") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 75:
                    map.put("Pie", map.get("Pie") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                case 100:
                    map.put("Pastry", map.get("Pastry") + 1);
                    liquids.poll();
                    ingredients.pop();
                    break;
                default:
                    liquids.poll();
                    ingredients.pop();
                    ingredients.push(ingredientNumber + 3);
                    break;
            }

        }
        if (map.get("Cake") > 0 && map.get("Biscuit") > 0 && map.get("Pie") > 0 && map.get("Pastry") > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println("Liquids left: " + getElementsInfo(liquids));
        System.out.println("Ingredients left: " + getElementsInfo(ingredients));

        map.forEach((key, value) -> System.out.println(key + ": " + value));


    }
    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "none" : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
