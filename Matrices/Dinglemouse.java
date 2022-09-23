package com.company.Tasks;

public class Dinglemouse {
    public static int peakHeight(char[][] mountain) {

        int height = 0;

        while (matrixHasChars(mountain)) {
            height++;
            for (int row = 0; row < mountain.length; row++) {
                char previousChar = ' ';
                for (int column = 0; column < mountain[row].length; column++) {
                    char charToCheck = mountain[row][column];
                    if (charToCheck == '^') {
                        if (checkIfCharIsNotCovered(row, column, mountain, height,previousChar)) {
                            if (height > 9) {
                                mountain[row][column] = String.valueOf(height).charAt(String.valueOf(height).length()-1);
                            } else {
                                mountain[row][column] = String.valueOf(height).charAt(0);
                            }
                        }
                    }
                    previousChar = charToCheck;
                }
            }
        }
        return height;
    }

    private static boolean matrixHasChars(char[][] mountain) {
        for (int row = 0; row < mountain.length; row++) {
            for (int cols = 0; cols < mountain[row].length; cols++) {
                char field = mountain[row][cols];
                if (field == '^') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkIfCharIsNotCovered(int row, int column, char[][] mountain, int height, char previousChar) {
        char charToCheck = mountain[row][column];
        if (charToCheck == ' ') {
            return false;
        }
        if (column == 0 || column == mountain[row].length - 1 || row == 0 || row == mountain.length - 1) {
            return true;
        }

        char charOnTheLeft = mountain[row - 1][column];
        char charOnTheRight = mountain[row + 1][column];
        char charUp = mountain[row][column - 1];
        char charDown = mountain[row][column + 1];

        if (checkTheChar(charOnTheLeft, height, previousChar) && checkTheChar(charOnTheRight, height, previousChar)
                && checkTheChar(charUp, height, previousChar) && checkTheChar(charDown, height, previousChar)) {
            return false;
        }
        return true;
    }

    private static boolean checkTheChar(char charToCheck, int height, char previousChar) {
        if (charToCheck == ' ') {
            return false;
        } if(charToCheck == previousChar && charToCheck == '^'){
            return true;
        }
        if(height<= 9){
            if (charToCheck == '^' || Integer.parseInt(String.valueOf(charToCheck)) == height) {
                return true;
            }} else {
            if (charToCheck == '^' || charToCheck == String.valueOf(height).charAt(String.valueOf(height).length() - 1)) {
                return true;
            }
        }
        return false;
    }
}
