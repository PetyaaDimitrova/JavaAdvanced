package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] arr = scan.nextLine().split(", ");
            String name = arr[0];
            int age = Integer.parseInt(arr[1]);
            map.put(name, age);
        }
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        Map<String, Integer> filteredMap = new LinkedHashMap<>();
        switch (condition) {
            case "older":
                for (Map.Entry<String,Integer> entry:map.entrySet()
                ) {
                    if(entry.getValue() >= age){
                        filteredMap.put(entry.getKey(), entry.getValue());
                    }
                }
                break;
            case "younger":
                for (Map.Entry<String,Integer> entry:map.entrySet()
                ) {
                    if(entry.getValue() <= age){
                        filteredMap.put(entry.getKey(), entry.getValue());
                    }
                }
                break;
        }
        String print = scan.nextLine();
        switch (print) {
            case "name age":
                for (Map.Entry<String, Integer> entry : filteredMap.entrySet()
                ) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
                break;
            case "name":
                for (Map.Entry<String, Integer> entry : filteredMap.entrySet()
                ) {
                    System.out.println(entry.getKey());
                }
                break;
            case "age":
                for (Map.Entry<String, Integer> entry : filteredMap.entrySet()
                ) {
                    System.out.println(entry.getValue());
                }
                break;
        }
    }
}
