package BackTracking;

import java.util.Scanner;

public class RatInTheMaze {
    private int n, m;
    private int[][] maze;
    private boolean[][] visit;

    @SuppressWarnings("resource")
    public RatInTheMaze() {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the rows and columns:");
        this.m = obj.nextInt();
        this.n = obj.nextInt();
        maze = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                maze[i][j] = obj.nextInt();

        if (!solveRM(0, 0)) {
            System.out.println("No path exists.");
            return;
        }
        System.out.println();
        maze[n - 1][m - 1] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    maze[i][j] = 0;
                }
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        obj.close();
    }

    private boolean solveRM(int i, int j) {
        if (i >= n || i < 0 || j >= m || j < 0 || maze[i][j] == 0) {
            return false;
        }

        if ((i > 0 && j > 0 && i < n - 1 && j < m - 1 && maze[i + 1][j] == 0 && maze[i - 1][j] == 0
                && maze[i][j + 1] == 0
                && maze[i][j - 1] == 0))
            return false;

        visit[i][j] = true;
        maze[i][j] = 0;
        if (i == n - 1 && j == m - 1) {
            visit[i][j] = true;
            return true;
        }
        if (solveRM(i + 1, j) ||
                solveRM(i, j + 1) ||
                solveRM(i - 1, j) ||
                solveRM(i, j - 1)) {
            maze[i][j] = 1;
            return true;
        }
        visit[i][j] = false;
        maze[i][j] = 1;
        return false;
    }
}