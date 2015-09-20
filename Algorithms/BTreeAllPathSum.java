import java.util.*;

class BTreeAllPathSum{
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}

	//Recursive
	public static int getSum(TreeNode root){
		if(root == null) return 0;
		ArrayList<Integer> pathsums = new ArrayList<>();
		helper(root, pathsums, 0);
		int res = 0;
		for(int i : pathsums) res+= i;
		return res;
	}

	public static void helper(TreeNode root, ArrayList<Integer> pathsums, int sum){
		int tmpsum = sum + root.val;
		if(root.left==null && root.right==null){
			pathsums.add(tmpsum);
			return;
		}
		if(root.left!=null) helper(root.left,pathsums,tmpsum);
		if(root.right!=null) helper(root.right,pathsums,tmpsum);
	}


	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(8);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		System.out.println(getSum(root));
	}
}