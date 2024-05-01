import java.util.Scanner;

public class App {
    @SuppressWarnings("unused")
    public static void main(String[] args) throws Exception {
        Scanner obj = new Scanner(System.in);
        int[][] board = new int[9][9];
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
                for(int i=0;i<9;i++) for(int j=0;j<9;j++) board[i][j]=obj.nextInt();
                new Sudoku(board);
                break;
            default:
                System.out.println("Wrong Input");
                break;
        }
        obj.close();
    }
}
