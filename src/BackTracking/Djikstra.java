package BackTracking;

import java.util.Scanner;

public class Djikstra {
    int N;
    int[][] graph;
    int[] dist;
    boolean[] set = new boolean[N];

    public Djikstra() {
        Scanner obj = new Scanner(System.in);
        N = obj.nextInt();
        graph = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) graph[i][j] = obj.nextInt();
        int source = obj.nextInt();
        solveDijkstra(source);
    }

    private void solveDijkstra(int source) {
        dist = new int[N];
        set = new boolean[N];
        dist[source] = 0;
        for (int i = 0; i < N; i++) {
            int temp = minDist();
            set[temp] = true;

            for (int k = 0; k < N; k++) {
                if (!set[i] && graph[temp][i] != 0 && dist[temp]!=Integer.MAX_VALUE && dist[temp]+graph[temp][i] < dist[0] )
                    dist[i]=dist[temp]+graph[temp][i];
            }
        }
        printGraph();
    }

    private void printGraph() {
        System.out.println("Vertex \t Distance From Source");
        for(int i=0;i<N;i++)
        {
            System.out.println(i+" \t\t "+dist[i]);
        }
    }

    private int minDist() {
        int ind = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++)
            if (!set[i] && dist[i] <= min) {
                ind = i;
                min = dist[i];
            }
        return ind;
    }
}
