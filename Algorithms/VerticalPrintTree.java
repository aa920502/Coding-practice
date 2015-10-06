
// Print arbitrary binary tree by vertical levels / columns from left to right


// example tree

//       a
//      / \
//     b   c
//    / \   \
//   d   g   z
//    \     /
//     e   i
//        /
//       q
//      /
//     x
//    /
//   x1
// x2

// sample output
// x2
// d x1
// b e x
// a g q
// c i
// z

import java.util.*;

public class VerticalPrintTree{

	static class TreeNode{
        TreeNode left;
        TreeNode right;
        String data;    
        TreeNode(String data){
            this.data = data;
        }
	}

	public static void Print(TreeNode root){
        ArrayList<ArrayList<String>> right = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> left = new ArrayList<ArrayList<String>>();
        printHelper(0, root, left, right);
        // Print result
        for(int i = left.size() - 1; i > 0; i--){
            System.out.println(left.get(i));
        }
        for(int i = 0; i < right.size(); i++){
            System.out.println(right.get(i));
        }
    }
    
     static void printHelper(int index, TreeNode root, ArrayList<ArrayList<String>> left, ArrayList<ArrayList<String>> right){
        // Base case
        if(root == null) return;
        // Normal case
        if(index >= 0){
            while(right.size() <= index){
                right.add(new ArrayList<String>());
            }
            right.get(index).add(root.data);
        }
        else{
            while(left.size() <= -index){
                left.add(new ArrayList<String>());
            }
            left.get(-index).add(root.data);
        }
        // Recurse
        printHelper(index - 1, root.left, left, right);
        printHelper(index + 1, root.right, left, right);
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode("a");
        root.left = new TreeNode("b");
        root.right = new TreeNode("c");
        
        root.left.left = new TreeNode("d");  
        root.left.right = new TreeNode("g");
        
        root.right.right = new TreeNode("z");
        root.right.right.left = new TreeNode("i");
        root.right.right.left.left = new TreeNode("q");
        root.right.right.left.left.left = new TreeNode("x");
        root.right.right.left.left.left.left = new TreeNode("x1");
        root.right.right.left.left.left.left.left = new TreeNode("x2");
        
        root.left.left.right = new TreeNode("e");
        
        
        Print(root);
   }

}