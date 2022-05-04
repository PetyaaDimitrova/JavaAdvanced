package Matrix;

import java.util.Scanner;

public class Ex_12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        int matrixSize = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        int startRow = 0;
        int startCol = 0;

        boolean hasWon = false;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("f")) {
                startRow = i;
                startCol = line.indexOf('f');
            }
        }
        matrix[startRow][startCol] = '-';

        String command = scan.nextLine();
        for (int i = 0; i < n; i++) {


            int previousRow = startRow;
            int previousCol = startCol;
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

            if (field == 'F') {
                System.out.println("Player won!");
                hasWon = true;
                break;
            } else if (field == 'B') {
                n++;
                continue;
            } else if (field == 'T') {
                startCol = previousCol;
                startRow = previousRow;
                field = matrix[startRow][startCol];
            }
            if (i < n - 1) {
                command = scan.nextLine();
            }
        }

        if (!hasWon) {
            System.out.println("Player lost!");

        }
        matrix[startRow][startCol] = 'f';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printTheMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[row][cols]);
            }
            System.out.println();
        }
    }


}

