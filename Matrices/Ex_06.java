package Matrix;

import java.util.Scanner;

public class Ex_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int presents = Integer.parseInt(scan.nextLine());
        int sizeOfMatrix = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[sizeOfMatrix][sizeOfMatrix];

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                startRow = i;
                startCol = line.indexOf('S');
            }
        }

        String command = scan.nextLine();


        int kidsGetPresent = findHowManyNiceKidsAreLiveThere(matrix);

        while (!command.equals("Christmas morning")) {
            matrix[startRow][startCol] = '-';
            char field;

            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        System.out.println("Santa ran out of presents!");
                        printResult(matrix, kidsGetPresent);
                        return;
                    }

                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        System.out.println("Santa ran out of presents!");
                        printResult(matrix, kidsGetPresent);
                        return;
                    }
                    break;

                case "left":
                    startCol--;
                    if (startCol < 0) {
                        System.out.println("Santa ran out of presents!");
                        printResult(matrix, kidsGetPresent);
                        return;
                    }
                    break;


                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        System.out.println("Santa ran out of presents!");
                        printResult(matrix, kidsGetPresent);
                        return;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field == 'C') {
                matrix[startRow][startCol] = 'S';

                int givenPresents = givePresentsToAll(matrix, startRow, startCol, presents);
                presents = presents - givenPresents;
                if (findHowManyNiceKidsAreLiveThere(matrix) == 0) {
                    printResult(matrix, kidsGetPresent);
                    return;//////////////////
                }
                if (presents == 0) {
                    System.out.println("Santa ran out of presents!");

                    printResult(matrix, kidsGetPresent);
                    return;
                }


            } else if (field == 'V') {
                presents--;
                if (presents == 0) {
                    System.out.println("Santa ran out of presents!");
                    matrix[startRow][startCol] = 'S';
                    printResult(matrix, kidsGetPresent);
                    return;
                }
                if (findHowManyNiceKidsAreLiveThere(matrix) == 0) {
                    printResult(matrix, kidsGetPresent);
                }
            } else if (field == '-') {
                matrix[startRow][startCol] = 'S';
            }
            command = scan.nextLine();

        }

        matrix[startRow][startCol] = 'S';
        printResult(matrix, kidsGetPresent);


    }

    private static int findHowManyNiceKidsAreLiveThere(char[][] matrix) {
        int kids = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'V') {
                    kids++;
                }
            }
        }
        return kids;
    }

    private static int givePresentsToAll(char[][] matrix, int startRow, int startCol, int presents) {
        int givenPresents = 0;
        int startPresents = presents;
        char field4 = matrix[startRow][startCol - 1];
        if (field4 == 'X' || field4 == 'V') {
            givenPresents++;
            matrix[startRow][startCol - 1] = '-';
            presents--;
            if (presents == 0) {
                matrix[startRow][startCol] = 'S';
                return startPresents;
            }
        }
        char field3 = matrix[startRow][startCol + 1];
        if (field3 == 'X' || field3 == 'V') {
            givenPresents++;
            presents--;
            matrix[startRow][startCol + 1] = '-';
            if (presents == 0) {
                matrix[startRow][startCol] = 'S';
                return startPresents;
            }

        }
        char field1 = matrix[startRow - 1][startCol];
        if (field1 == 'X' || field1 == 'V') {
            givenPresents++;
            presents--;
            matrix[startRow - 1][startCol] = '-';
            if (presents == 0) {
                matrix[startRow][startCol] = 'S';
                return startPresents;
            }

        }
        char field2 = matrix[startRow + 1][startCol];
        if (field2 == 'X' || field2 == 'V') {
            givenPresents++;
            presents--;
            matrix[startRow + 1][startCol] = '-';
            if (presents == 0) {
                matrix[startRow][startCol] = 'S';
                return startPresents;
            }

        }
        return givenPresents;
    }

    private static void printResult(char[][] matrix, int kids) {
        for (int row = 0; row < matrix.length; row++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[row][cols] + " ");
            }
            System.out.println();
        }
        int leftKids = findHowManyNiceKidsAreLiveThere(matrix);
        if (leftKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", kids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", leftKids);
        }


    }
} /*
3
5
- - V S -
- X C - -
- - V - -
- - - - -
- - X - -
down
left
right
Christmas morning
*/