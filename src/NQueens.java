import java.util.Scanner;

public class NQueens {
    private int N;
    int[][] board;

    public NQueens() {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter The Size Of The Chess Board:");
        N = obj.nextInt();
        board = new int[N][N];
        solveNQueen();
        obj.close();
    }

    private void solveNQueen() {
        if (!solve(0)) {
            System.out.println("No Possible Out Put");
            return;
        }
        printResult();
        return;
    }

    private void printResult() {
        for (int[] row : board) {
            for (int i : row) {
                if (i == 0)
                    System.out.print("- ");
                else
                {
                    System.out.print("\u001B[1m");
                    System.out.print("\033[0;35m"+"Q ");
                    System.out.print("\033[0m"+"\u001B[1m");
                }
            }
            System.out.println();
        }
    }

    private boolean solve(int col) {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solve(col + 1))
                    return true;
                board[i][col] = 0;
            }
            board[i][col] = 0;
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        int i, j;
        for (i = 0; i < N; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }
}
