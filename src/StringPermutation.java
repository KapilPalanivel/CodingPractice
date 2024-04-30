import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutation {
    private List<String> res;
    public StringPermutation()
    {
        Scanner obj=new Scanner(System.in);
        res=new ArrayList<>();
        System.out.print("Enter the string for permutaion:");
        perm(obj.nextLine(),"");
        System.out.println();
        System.out.println(res.toString());
        obj.close();
    }

    private void perm(String input, String output) {
        if (input.length() == 0)
            res.add(output);
        for (int i = 0; i < input.length(); i++) {
            String re = input.substring(0, i) + input.substring(i + 1);
            perm(re, output + input.charAt(i));
        }
    }
}
