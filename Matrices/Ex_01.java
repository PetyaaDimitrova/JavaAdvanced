package Dec16;

import java.util.*;
import java.util.stream.Collectors;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Bread", 0);
        map.put("Cake", 0);
        map.put("Fruit Pie", 0);
        map.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquidNumber = liquids.poll();
            int ingredientNumber = ingredients.pop();

            int sum = liquidNumber + ingredientNumber;

            switch (sum) {
                case 25:
                    map.put("Bread", map.get("Bread") + 1);
                    break;
                case 50:
                    map.put("Cake", map.get("Cake") + 1);
                    break;
                case 75:
                    map.put("Fruit Pie", map.get("Fruit Pie") + 1);
                    break;
                case 100:
                    map.put("Pastry", map.get("Pastry") + 1);
                    break;
                default:
                    int newNumber = ingredientNumber + 3;
                    ingredients.push(newNumber);
                    break;

            }

        }
        if (map.get("Cake") > 0 && map.get("Bread") > 0 && map.get("Fruit Pie") > 0 && map.get("Pastry") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.println("Liquids left: " + getElementsInfo(liquids));
        System.out.println("Ingredients left: " + getElementsInfo(ingredients));

        map.forEach((key, value) -> System.out.println(key + ": " + value));


    }

    private static String getElementsInfo(ArrayDeque<Integer> deque) {
        return deque.isEmpty() ? "none" : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
