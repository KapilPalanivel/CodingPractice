import java.util.Scanner;

public class Lrgst_rect_In_hist {
    private final int N;
    private final int[] heights;

    public Lrgst_rect_In_hist(Scanner obj) {
        N = obj.nextInt();
        heights = new int[N];
        for (int i = 0; i < N; i++) heights[i] = obj.nextInt();
        System.out.println("The Largest Rectangle In Histogram : " + solveArea());
    }

    private int solveArea() {
        int max = 0, ind = -1;
        int[] stack = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            int height = (i == N) ? 0 : heights[i];
            while (ind != -1 && height <= heights[stack[ind]]) {
                int h = heights[stack[ind--]];
                int width = (ind == -1) ? i : i - stack[ind] - 1;
                max = Math.max(max, h * width);
            }
            stack[++ind] = i;
        }
        return max;
    }
}
