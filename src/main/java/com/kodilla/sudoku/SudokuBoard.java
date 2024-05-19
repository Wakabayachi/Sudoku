package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private final List<SudokuRow> rows;

    public SudokuBoard() {
        rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                builder.append(rows.get(i).getElements().get(j)).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}