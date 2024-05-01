import java.util.Scanner;

public class App {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        Scanner obj = new Scanner(System.in);
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int choice = obj.nextInt();
        switch (choice) {
            case 1:
                new RatInTheMaze();
                break;
            case 2:
                new EggDrop();
                break;
            case 3:
                new StringPermutation();
            case 4:
                new NQueens();
                break;
            case 5:
                new HamiltonCycle();
                break;
            case 6:
                new Sudoku(board);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
        obj.close();
    }
}
