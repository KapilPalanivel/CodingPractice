import java.util.*;

public class Parantesis_Permutaion {
    int num;
    char[] brac;
    public Parantesis_Permutaion(Scanner obj) {
        int n = obj.nextInt();
        boolean shouldPrint = false;
        num=0;
        brac=new char[n*2];
        System.out.print("Do you want to Print all the permutations: ");
        shouldPrint = obj.nextBoolean();
        if (shouldPrint) {
            findPerms(brac,n,0,0,0);
            System.out.println(num);
        }
    }
    private void findPerms(char[] brac, int n, int pos, int open, int close) {
        if(close==n)
        {
            num++;
            for(char ch:brac) System.out.print(ch+" ");
            System.out.println();
            return;
        }
        else
        {
            if(open>close)
            {
                brac[pos]='}';
                findPerms(brac, n, pos+1, open, close+1);
            }
            if(open<n)
            {
                brac[pos]='{';
                findPerms(brac, n, pos+1, open+1, close);
            }
        }
    }
}
