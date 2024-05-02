import java.util.Scanner;

@SuppressWarnings("unused")
public class EggDrop {
    EggDrop() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the Eggs & Floor Count");
        int egg = obj.nextInt();
        int floor = obj.nextInt();
        System.out.println(solveEggDrop1D(egg, floor));
        obj.close();
    }

    private int solveEggDrop1D(int egg, int floor) {
        int[] arr = new int[egg + 1];
        int m = 0;
        for (m = 0; arr[egg] < floor; m++) {
            for (int i = egg; i > 0; i--) {
                arr[i] += arr[i - 1] + 1;
            }
        }
        return m;
    }
}