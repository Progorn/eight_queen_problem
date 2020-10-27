package com.company;

public class Game {
    // Width and length of the board
    public static final int N = 8;

    // We start with 1 to keep the zero as a no Queen indicator
    public static final int A = 1;
    public static final int H = 8;

    // We start with 0 because arrays are zero-indexed.
    public static final int ONE = 0;
    public static final int EIGHT = 7;

    /*
     * We only need a one dimensional array:
     * The key is the identifier of the row.
     * The value show if there is a queen or not.
     * 0 means no queen. Another number indicates the collum where the lines queen is placed.
     */
    protected int[] board = new int[N];

    // Counter to check if the alogorithm works.
    public int solutions = 0;

    /**
     * @param row int
     */
    public void finishConfiguration(int row) {
        int placement;

        for (placement = A; placement <= H; placement++) {
            board[row] = placement;
            if (queenIsSave(row)) {
                if (row < EIGHT) {
                    finishConfiguration(row + 1);
                } else {
                    printBoard();
                }
            }
        }
    }

    /**
     * Method to look for queens that are able to attack the new queen.
     * @param row int
     * @return boolean
     */
    private boolean queenIsSave(int row) {
        int collum = board[row];

        // Loop for every collum left from our queen
        for (int i = 0; i < row; i++)
        {
            if (
                    // Check if there is a queen in the same row
                    board[i] == collum ||
                    // Check if there is a queen to the bottom left
                    board[row - (i + 1)] == collum - (i + 1) ||
                    // Check if there is a queen to the top left
                    board[row - (i + 1)] == collum + (i + 1)
                )
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Prints the given board into std:out.
     * 'X' show the position of a queen
     */
    private void printBoard() {
        solutions++;
        int row = N;
        for (int counterX = ONE; counterX < N; counterX++) {
            System.out.print(row + ":");
            for (int counterY = ONE; counterY <= N; counterY++) {
                if (board[counterX] == counterY) {
                    System.out.print('X');
                } else {
                    System.out.print(' ');
                }
            }
            row--;
            System.out.println();
        }
        System.out.print("  ");
        char lineDescription = 'A';
        for (int i = 0; i < N; i++) {
            System.out.print(lineDescription);
            lineDescription++;
        }
        System.out.println();
        System.out.println("----------");
    }

    /**
     * Returns the first occurence of the int-number in the array of int-numbers.
     * @param needle int
     * @param haystack int[]
     * @return int
     */
    public static int indexOf(int needle, int[] haystack)
    {
        for (int i=0; i<haystack.length; i++)
        {
            if (haystack[i] == needle)
                return i;
        }

        return -1;
    }
}
