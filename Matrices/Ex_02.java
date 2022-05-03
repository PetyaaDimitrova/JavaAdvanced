package Dec16;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        ArrayDeque<Integer> task = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(task::push);

        ArrayDeque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // opashka

        int n = Integer.parseInt(scan.nextLine());

        while (!task.isEmpty() && !threads.isEmpty()){
            int threadValue = threads.peek();
            int taskValue = task.peek();
            if(taskValue == n){
                System.out.printf("Thread with value %d killed task %d", threadValue, taskValue);
                break;
            }
            threads.poll();
            if(threadValue >= taskValue){
                task.pop();
            }
            // the thread value is less than the task value, the thread gets removed, but the task remains.
        }
        System.out.println();
        while (!threads.isEmpty()){
            System.out.print(threads.poll() + " ");
        }
    }
}
