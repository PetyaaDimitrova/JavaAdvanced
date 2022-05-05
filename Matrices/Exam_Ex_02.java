package Exam_19August;

import java.util.Scanner;

public class Exam_Ex_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int energy = Integer.parseInt(scan.nextLine());

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];


        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("P")) {
                startRow = i;
                startCol = line.indexOf('P');
            }
        }

        while (true){
            matrix[startRow][startCol] = '-';
            String[] input = scan.nextLine().split(" ");
            String command = input[0];
            int rowIndex = Integer.parseInt(input[1]);
            int colIndex = Integer.parseInt(input[2]);
            matrix[rowIndex][colIndex] = 'S';



            char field;


            switch (command) {
                case "up":
                    energy--;
                    startRow--;
                    if (startRow < 0) {
                       startRow++;

                    }

                    break;
                case "down":
                    energy--;
                    startRow++;
                    if (startRow > matrix.length - 1) {
                       startRow = matrix.length - 1;

                    }
                    break;

                case "left":
                    energy--;
                    startCol--;
                    if (startCol < 0) {
                        startCol++;
                    }
                    break;


                case "right":
                    energy--;
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        startCol = matrix.length - 1;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == 'S') {
               energy = energy - 2;
            } else if (field == 'H') {
               matrix[startRow][startCol] = '-';
              System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                printMatrix(matrix);
                return;

            }
            if(energy <=0){
                System.out.printf("Paris died at %d;%d.%n", startRow, startCol);
                matrix[startRow][startCol] = 'X';
                printMatrix(matrix);
                return;
            }

        }


    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
