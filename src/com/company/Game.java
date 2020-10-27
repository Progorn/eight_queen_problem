package com.company;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static final int N = 8;

    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 8;

    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    public static final int SIX = 5;
    public static final int SEVEN = 6;
    public static final int EIGHT = 7;

    protected int[] board = new int[N];

    public int solutions = 0;

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
        board[row] = 0;
    }

    private boolean queenIsSave(int row) {
        int collum = board[row];
        int index = indexOf(collum, board);
        if (index != row) {
            return false;

        }else{
            int distance = 1;
            while (row - distance >= ONE && collum - distance >= A)
            {
                if (board[row - distance] == collum - distance)
                {
                    return false;
                }
                distance++;
            }
            distance = 1;
            while (row - distance >= ONE && collum + distance <= N)
            {
                if (board[row - distance] == collum + distance)
                {
                    return false;
                }
                distance++;
            }
            distance = 1;
            while (row + distance <= N - 1 && collum - distance >= A)
            {
                if (board[row + distance] == collum - distance)
                {
                    return false;
                }
                distance++;
            }
            distance = 1;
            while (row + distance <= N - 1 && collum + distance <= N)
            {
                if (board[row + distance] == collum + distance)
                {
                    return false;
                }
                distance++;
            }
        }
        return true;
    }

    private void printBoard() {
        solutions++;
        for (int counterX = A; counterX < N; counterX++) {
            for (int counterY = A; counterY < N; counterY++) {
                if (board[counterX] == counterY) {
                    System.out.print('X');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
        System.out.println("--------");
    }

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
