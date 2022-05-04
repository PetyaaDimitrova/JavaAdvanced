package Matrix;

import java.util.Scanner;

public class Ex_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        StringBuilder sb = new StringBuilder(word);

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

        matrix[startRow][startCol] = '-';

        String command = scan.nextLine();

        while (!command.equals("end")){

            char field;

            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        startRow = 0;
                        sb.deleteCharAt(sb.length()-1);
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        startRow = matrix.length - 1;
                        sb.deleteCharAt(sb.length()-1);
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        startCol = 0;
                        sb.deleteCharAt(sb.length()-1);
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        startCol = matrix.length - 1;
                        sb.deleteCharAt(sb.length()-1);
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field != '-') {
                sb.append(field);
            }
            matrix[startRow][startCol] = '-';

            command = scan.nextLine();
        }

        matrix[startRow][startCol] = 'P';
        System.out.println(sb.toString());
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[row][cols]);
            }
            System.out.println();
        }

    }
}
