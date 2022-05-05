package Exam_19August;

import java.util.Scanner;

public class Ex_15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        char[][] matrix = new char[n][n];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                startRow = i;
                startCol = line.indexOf('S');
            }
        }



        int food=0;

        while (true){
            matrix[startRow][startCol] = '.';
            String command = scan.nextLine();

            char field;


            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        System.out.println("Game over!");
                        printResult(matrix, food);
                        return;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        System.out.println("Game over!");
                        printResult(matrix, food);
                        return;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        System.out.println("Game over!");
                        printResult(matrix, food);
                        return;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        System.out.println("Game over!");
                        printResult(matrix, food);
                        return;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == '*') {
               food++;
                if(food == 10){
                    System.out.println("You won! You fed the snake. ");
                    matrix[startRow][startCol] = 'S';
                    printResult(matrix, food);
                    return;
                }
            } else if (field == 'B') {
               int[]arr = findOtherBurrow(matrix);
               matrix[startRow][startCol] = '.';
               startRow = arr[0];
               startCol = arr[1];

            }


        }
    }

    private static int[] findOtherBurrow(char[][] matrix) {
        int[]arr = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'B'){
                    arr[0] = row;
                    arr[1] = col;
                    break;
                }
            }
        }
        return arr;
    }

    private static void printResult(char[][] matrix, int food) {

            System.out.printf("Food eaten: %d", food);
            System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }


}
