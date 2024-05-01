import java.util.Arrays;

public class Sudoku {
    private final int N = 9;
    private int[][] sudoku;

    Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
        if (!solve())
            System.out.println("No Solution Exist");
        else
            print();

    }

    private void print() {
        Arrays.stream(sudoku).forEach(row->{Arrays.stream(row).forEach(i -> System.out.print(i+"\t"));System.out.print("\n");});
    }

    private boolean solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sudoku[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(i, j, num)) {
                            sudoku[i][j] = num;
                            if (solve())
                                return true;
                            sudoku[i][j] = 0;
                        }
                    }
                    return false; // If no number is valid, backtrack
                }
            }
        }
        return true; // If no empty cell found, the puzzle is solved
    }

    private boolean isSafe(int row, int col, int num) {
        // Check the row
        for (int i = 0; i < N; i++) {
            if (sudoku[row][i] == num)
                return false;
        }

        // Check the column
        for (int i = 0; i < N; i++) {
            if (sudoku[i][col] == num)
                return false;
        }

        // Check the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (sudoku[r + startRow][c + startCol] == num)
                    return false;
            }
        }
        return true;
    }
}
