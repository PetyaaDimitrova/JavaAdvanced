package Matrix;

import java.util.Scanner;

public class Ex_10 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

// В СЛУЧАЙ, ЧЕ КАТО ИЗЛЕЗЕ ИЗВЪН МАТРИЦАТА, ПРОГРАМАТА ПРИКЛЮЧВА

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];


        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("M")) {
                startRow = i;
                startCol = line.indexOf('M');
            }
        }


        String command = scan.nextLine();
        int cheeses = 0;

        while (!command.equals("end")) {
            matrix[startRow][startCol] = '-';
            char field;


            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        System.out.println("Where is the mouse?");
                        printResult(matrix, cheeses);
                        return;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        System.out.println("Where is the mouse?");
                        printResult(matrix, cheeses);
                        return;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        System.out.println("Where is the mouse?");
                        printResult(matrix, cheeses);
                        return;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        System.out.println("Where is the mouse?");
                        printResult(matrix, cheeses);
                        return;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == 'c') {
                cheeses++;
                matrix[startRow][startCol] = 'M';

            } else if (field == 'B') {
                matrix[startRow][startCol] = 'M';
                continue;
            } else if (field == '-') {
                matrix[startRow][startCol] = 'M';
            }
            command = scan.nextLine();

        }
        printResult(matrix,cheeses);

    }

    private static void printResult(char[][] matrix, int cheeses) {
        if (cheeses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - cheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!", cheeses);
        }
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[row][cols]);
            }
            System.out.println();
        }
    }
}
