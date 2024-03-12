import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main{

    public static void main(String args[])
    {
        int data;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root node's value : ");
        data = sc.nextInt();
        Node root = new Node(data);
        while(true)
        {
            System.out.print("Enter elements's value : ");
            data = sc.nextInt();
            if(data == -1) break;
            insert(data,root);
        }
        System.out.print("\nInorder travesal of the tree : ");
        inorder(root);
        System.out.print("\nPreorder travesal of the tree : ");
        preorder(root);
        System.out.print("\nPostorder travesal of the tree : ");
        postorder(root);
        System.out.print("\nMaximum height of the tree is : " +height(root));
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.print("\nLeft view of the tree is : ");
        printLeft(root,0,ans);
        for(int i=0;i<ans.size();i++)
        {
            System.out.print(ans.get(i)+" ");
        }
        System.out.print("\nMax element is : "+maxBST(root));
        System.out.print("\nMin element is : "+minBST(root));
        //Delete a node -> take the max val in left side or min val in right side....
        System.out.print("\nEnter the node value to be deleted : " );
        data = sc.nextInt();
        deleteBST(root,data);
        System.out.print("\nInorder after deletion is : ");
        inorder(root);
        System.out.print("\nLeaf nodes are : ");
        printRoot(root);
    }
    public static void insert(int data,Node root)
    {
        if(data < root.data)
        {
            if(root.left != null) insert(data,root.left);
            else root.left = new Node(data);
        }
        else{
            if(root.right != null)insert(data,root.right);
            else  root.right = new Node(data);
        }
    }
    public static void inorder(Node root)
    {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void preorder(Node root)
    {
        if(root == null) return;
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root)
    {
        if(root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static int height(Node root)
    {
        if(root == null) return 0;
        
        int left =  height(root.left);
        int right = height(root.right);
        
        return Math.max(left,right) + 1;
    }
    public static void printLeft(Node root, int level, ArrayList<Integer> ans)
    {
        if(root == null) return;
        
        if(ans.size() == level) ans.add(root.data);
        
        printLeft(root.left,level+1,ans);
        printLeft(root.right, level+1,ans);
    }
     public static int maxBST(Node root)
     {
         if(root == null) return 0;
         else if(root.right==null) return root.data;
         else return maxBST(root.right);
     }
     public static int minBST(Node root)
     {
         if(root == null) return 0;
         else if(root.left==null) return root.data;
         else return minBST(root.left);
     }
    public static Node deleteBST(Node root, int data)
    {
        if(root == null) return null;
        else{
            if(data < root.data) root.left=deleteBST(root.left,data);
            else if(data> root.data) root.right=deleteBST(root.right,data);
            else{
                if(root.left==null && root.right == null) {
                    return null;
                }
                else if(root.left==null)
                {
                    return root.right;
                }
                else if(root.right == null)
                {
                    return root.left;
                }
                else{
                    int val = maxBST(root.left); //can also be maxBST(root.left);
                    root.data = val;
                    root.left = deleteBST(root.left,val); // root.right = deleteBST(root.right,val);
                    return root;
                }
            }
        }
        return root;
    }
    public static void printRoot(Node root)
    {
        if(root == null) return;
        
        if(root.right==null && root.left==null) 
        {
            System.out.print(root.data+" ");
            return;
        }
        
        if(root.left!=null) printRoot(root.left);
        if(root.right!=null) printRoot(root.right);
    }
}
