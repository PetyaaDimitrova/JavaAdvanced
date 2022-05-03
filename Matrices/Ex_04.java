package Dec16;

import java.util.*;
import java.util.stream.Collectors;

public class Ex_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> daffodils = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // opashka

        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(tulips::push);

        List<Integer> list = new ArrayList<>();

        int bouquets= 0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int daffodilsNumber = daffodils.peek();
            int tulipsNumber = tulips.peek();

            int sum = daffodilsNumber + tulipsNumber;

            if(sum == 15){
                bouquets++;
                daffodils.poll();
                tulips.pop();
            }else if(sum > 15){
                tulips.pop();
                tulips.push(tulipsNumber - 2);
            } else {
                daffodils.poll();
                tulips.pop();
                list.add(daffodilsNumber);
                list.add(tulipsNumber);

            }
        }
        int n = 0;
        for (int a:list
             ) {
            n+=a;
        }

        int newBouquets = n / 15;

        bouquets = bouquets + newBouquets;
        if(bouquets >=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
