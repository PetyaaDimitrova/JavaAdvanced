package Matrix;

import java.util.Scanner;

public class Ex_13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[]arr = scan.nextLine().split(", ");

        char[][] matrix = new char[n][n];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
            if (line.contains("s")) {
                startRow = i;
                startCol = line.indexOf('s');
            }
        }


        matrix[startRow][startCol] = '*';

        int size = 1;

        for(int i = 0 ; i<arr.length; i++){
            String command = arr[i];
            char field;


            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        startRow = matrix.length - 1;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        startRow = 0;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        startCol = matrix.length - 1;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        startCol = 0;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == 'f') {
                size++;
                matrix[startRow][startCol] = '*';
               if(checkFood(matrix) == 0){
                   System.out.printf("You win! Final python length is %d", size);
                   return;
               }
            } else if (field == 'e') {
               System.out.println("You lose! Killed by an enemy!");
               return;
            }


        }

        System.out.printf("You lose! There is still %d food to be eaten.", checkFood(matrix));

    }

    private static int checkFood(char[][] matrix) {
        int leftFood = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
              if(matrix[row][col] == 'f'){
                  leftFood++;
              }
            }
        }
        return leftFood;
    }
}
