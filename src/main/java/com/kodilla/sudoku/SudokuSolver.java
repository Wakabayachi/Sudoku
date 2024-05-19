package com.kodilla.sudoku;

import java.util.*;

public class SudokuSolver {

    public boolean solve(SudokuBoard board) {
        int[] emptySpot = findEmptySpot(board);
        if (emptySpot == null) {
            return true;
        }

        int row = emptySpot[0];
        int col = emptySpot[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board.getRows().get(row).getElements().get(col).setValue(num);
                if (solve(board)) {
                    return true;
                }
                board.getRows().get(row).getElements().get(col).setValue(SudokuElement.EMPTY);
            }
        }

        return false;
    }

    private int[] findEmptySpot(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getRows().get(row).getElements().get(col).getValue() == SudokuElement.EMPTY) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private boolean isSafe(SudokuBoard board, int row, int col, int num) {
        return !isInRow(board, row, num) &&
                !isInCol(board, col, num) &&
                !isInBox(board, row - row % 3, col - col % 3, num);
    }

    private boolean isInRow(SudokuBoard board, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board.getRows().get(row).getElements().get(col).getValue() == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(SudokuBoard board, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board.getRows().get(row).getElements().get(col).getValue() == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(SudokuBoard board, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getRows().get(row + boxStartRow).getElements().get(col + boxStartCol).getValue() == num) {
                    return true;
                }
            }
        }
        return false;
    }
}