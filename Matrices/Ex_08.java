package Matrix;

import java.util.Scanner;

public class Ex_08 {
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

        String command = scan.nextLine();

        int sum = 0;

        while (true){
            matrix[startRow][startCol] = '-';
            char field;


            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        System.out.println("Bad news, you are out of the bakery.");
                        printResult(matrix, sum);
                        return;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        System.out.println("Bad news, you are out of the bakery.");
                        printResult(matrix, sum);
                        return;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        System.out.println("Bad news, you are out of the bakery.");
                        printResult(matrix, sum);
                        return;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        System.out.println("Bad news, you are out of the bakery.");
                        printResult(matrix, sum);
                        return;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (Character.isDigit(field)) {

                sum =sum + (int) field -48;
                matrix[startRow][startCol] = 'S';
                if(sum >= 50){
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    printResult(matrix,sum);
                    return;
                }


            } else if (field == 'O') {
                matrix[startRow][startCol] = '-';
                boolean isFound = false;
                for (int row = 0; row < matrix.length; row++) {
                    if(isFound){
                        break;
                    }
                    for (int col = 0; col < matrix[row].length; col++) {
                        if(matrix[row][col] == 'O'){
                            startRow = row;
                            startCol = col;
                            matrix[startRow][startCol] = 'S';
                            isFound = true;
                            break;
                        }
                    }

                }

            } else if (field == '-') {
                matrix[startRow][startCol] = 'S';
            }
            command = scan.nextLine();
        }
    }
    private static void printResult(char[][] matrix, int sum) {
        System.out.printf("Money: %d%n", sum);

        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[row][cols]);
            }
            System.out.println();
        }
    }
}
