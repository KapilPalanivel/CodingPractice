import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generate_permutation_BST 
{
    class Node
    {
        int val;
        Node right,left;
        Node(int val){this.val=val;}
    }
    int n;
    Generate_permutation_BST(Scanner obj)
    {
        n=obj.nextInt();
        List<Node> lis=generateLBST(1,n);
        for(Node rootNode:lis)
        {
            preorder(rootNode);
            System.out.println();
        }
    }
    private void preorder(Generate_permutation_BST.Node rootNode) {
        if(rootNode==null) return;
        System.out.print(rootNode.val+" ");
        preorder(rootNode.left);
        preorder(rootNode.right);
        return;
    }
    private List<Generate_permutation_BST.Node> generateLBST(int start, int end) 
    {
        List<Node> allBST=new ArrayList<>();
        if(start>end)
        {
            allBST.add(null);
            return allBST;
        }
        for(int i=start;i<=end;i++)
        {
            Node node=new Node(i);
            List<Node> leftBST=generateLBST(start,i-1);
            List<Node> rightBST=generateLBST(i+1,end);
            for(Node left:leftBST)
            {
                for(Node right:rightBST)
                {
                    node.left=left;
                    node.right=right;
                    allBST.add(node);
                }
            }
        }
        return allBST;
    }
}
