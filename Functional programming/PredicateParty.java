package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> names = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scan.nextLine();


        while (!input.equals("Party!")) {
            String[] arr = input.split(" ");
            String command = arr[0];
            String condition = arr[1];
            String last = arr[2];

            switch (command) {
                case "Remove":
                    switch (condition) {
                        case "StartsWith":
                            names = names.stream().filter(el -> !el.startsWith(last)).collect(Collectors.toList());
                            break;
                        case "EndsWits":
                            names = names.stream().filter(el -> !el.endsWith(last)).collect(Collectors.toList());
                            break;
                        case "Length":
                            int length = Integer.parseInt(last);
                            names = names.stream().filter(el -> el.length() != length).collect(Collectors.toList());
                            break;
                    }
                    break;
                case "Double":
                    List<String> doubled;
                    switch (condition) {
                        case "StartsWith":
                            doubled = names.stream().filter(el -> el.startsWith(last)).collect(Collectors.toList());
                            names.addAll(doubled);
                            break;
                        case "EndsWith":
                            doubled = names.stream().filter(el -> el.endsWith(last)).collect(Collectors.toList());
                            names.addAll(doubled);
                            break;
                        case "Length":
                            int length = Integer.parseInt(last);
                            doubled = names.stream().filter(el -> el.length() == length).collect(Collectors.toList());
                            names.addAll(doubled);
                            break;
                    }
                    break;
            }


            input = scan.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            names = names.stream().sorted(String::compareTo).collect(Collectors.toList());
            for(int i = 0; i<names.size(); i++){
                if(i == names.size()-1){
                    System.out.print(names.get(i) + " ");
                    break;
                } System.out.print(names.get(i) + ", ");
            }
            System.out.print("are going to the party!");
        }
    }
}
