package com.kodilla.sudoku;

import java.util.Scanner;

public class SudokuGame {
    private final SudokuBoard board;
    private final SudokuSolver solver;
    private final Scanner scanner;

    public SudokuGame() {
        this.board = new SudokuBoard();
        this.solver = new SudokuSolver();
        this.scanner = new Scanner(System.in);
    }

    public boolean resolveSudoku() {
        System.out.println("Sudoku Solver");
        System.out.println("Enter your Sudoku puzzle values as 'row,col,value' or type 'SUDOKU' to solve:");

        while (true) {
            System.out.println(board);
            System.out.print("Enter row, col, value: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("SUDOKU")) {
                break;
            }

            String[] parts = input.split(",");
            if (parts.length == 3) {
                try {
                    int row = Integer.parseInt(parts[0].trim()) - 1;
                    int col = Integer.parseInt(parts[1].trim()) - 1;
                    int value = Integer.parseInt(parts[2].trim());

                    if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
                        board.getRows().get(row).getElements().get(col).setValue(value);
                    } else {
                        System.out.println("Invalid input. Please enter values between 1 and 9.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format. Please enter 'row,col,value'.");
                }
            } else {
                System.out.println("Invalid input format. Please enter 'row,col,value'.");
            }
        }

        if (solver.solve(board)) {
            System.out.println("Sudoku Solved:");
            System.out.println(board);
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }

        System.out.print("Do you want to solve another Sudoku? (yes/no): ");
        String answer = scanner.nextLine();
        return !answer.equalsIgnoreCase("yes");
    }
}