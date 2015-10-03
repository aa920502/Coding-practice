//Given a binary tree, print all root-to-leaf paths  

import java.util.*;

class PrintAllPaths{
	static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;    
        TreeNode(int val){
            this.val = val;
        }
	}


	public static void Print(TreeNode root){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> tmp = new LinkedList<>();
		helper(res,tmp,root);
		for(List<Integer> l : res){
			for(int i : l){
				System.out.print(i + " " );
			}
			System.out.println();
		}
	}

	public static void helper(List<List<Integer>> res,List<Integer> tmp,TreeNode root){
		List<Integer> ll = new LinkedList<>(tmp);
		ll.add(root.val);
		if(root.left==null && root.right==null){
			res.add(ll);
			return;
		}
		if(root.left!=null) helper(res,ll,root.left);
		if(root.right!=null) helper(res,ll,root.right);
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		Print(root);
	}
}