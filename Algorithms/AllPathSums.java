// calculate sum of all paths in a binary tree

import java.util.*;

class AllPathSums{
	public int getSum(TreeNode root){
		if(root==null) return 0;
		List<Integer> l = new ArrayList<>();
		helper(root,l,0);

		int res = 0;
		for(int i : l ) res += i;
		return res;
	}

	public void helper(TreeNode root, List<Integer> l, int sum){
		int tmp = sum + root.val;
		if(root.left==null && root.right==null){
			l.add(tmp);
			return;
		}
		if(root.left!=null) helper(root.left, l, tmp);
		if(root.right!=null) helper(root.right, l, tmp);
	}
	public static void main(String[] args){
		AllPathSums i = new AllPathSums();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);
		root.left.right.right = new TreeNode(45);

		System.out.println(i.getSum(root));
	}
}

	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val){
			this.val = val;
		}
	}