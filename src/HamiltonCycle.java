import java.util.Arrays;
import java.util.Scanner;

public class HamiltonCycle {
    
    int N;
    int[][] matrix;
    int[] path;
    HamiltonCycle()
    {
        Scanner obj=new Scanner(System.in);
        N=obj.nextInt();
        matrix=new int[N][N];
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) matrix[i][j]=obj.nextInt();
        hamCycle();
        obj.close();
    }
    private void hamCycle()
    {
        path=new int[N];
        Arrays.fill(path, -1);
        path[0]=0;
        if(!hamCycleUtil(1))
        {
            System.out.println("Hamiltonian cycle not found");
            return;
        }
        print();
    }
    private boolean hamCycleUtil(int pos)
    {
        if(pos==N)
        {
            return (matrix[path[pos-1]][path[0]]==1)?true:false;
        }
        for(int v=1;v<N;v++)
        {
            if(isSafe(v,pos))
            {
                path[pos]=v;
                if(hamCycleUtil(pos+1)) return true;
                path[pos]=-1;
            }
        }
        return false;
    }
    private boolean isSafe(int v,int pos)
    {
        if(matrix[path[pos-1]][v]==0) return false;
        for(int i=1;i<pos;i++)
            if(path[i]==v) return false;
        return true;
    }
    private void print()
    {
        System.out.println();
        for(int i:path) System.out.print(i+" ");
    }
}
