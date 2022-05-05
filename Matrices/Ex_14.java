package Exam_19August;

import java.util.Scanner;

public class Ex_14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];


        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("B")) {
                startRow = i;
                startCol = line.indexOf('B');
            }
        }

        String command = scan.nextLine();
        int pollinatedFlowers = 0;

        while (!command.equals("End")){
            matrix[startRow][startCol] = '.';
            char field;


            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        System.out.println("The bee got lost!");
                        printResult(matrix, pollinatedFlowers);
                        return;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        System.out.println("The bee got lost!");
                        printResult(matrix, pollinatedFlowers);
                        return;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        System.out.println("The bee got lost!");
                        printResult(matrix, pollinatedFlowers);
                        return;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        System.out.println("The bee got lost!");
                        printResult(matrix, pollinatedFlowers);
                        return;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == 'f') {
                pollinatedFlowers++;
                matrix[startRow][startCol] = 'B';

            } else if (field == 'O') {
                matrix[startRow][startCol] = 'B';
                continue;
            } else if (field == '.') {
                matrix[startRow][startCol] = 'B';
            }



            command = scan.nextLine();
        }
        printResult(matrix, pollinatedFlowers);

    }

    private static void printResult(char[][] matrix, int pollinatedFlowers) {
        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers);
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
