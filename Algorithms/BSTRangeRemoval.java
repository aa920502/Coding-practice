// A BST node has key, and left and right pointers
// Resmoves all nodes having value outside the given range and returns the root
// of modified tree

class BSTRangeRemoval{
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}

	public static TreeNode RemoveOutsideRange(TreeNode root, int min, int max){
		if(root == null) return null;
		root.left = RemoveOutsideRange(root.left, min, max);
		root.right = RemoveOutsideRange(root.right,min,max);

		if(root.val < min) return root.right==null?null:root.right;
		if(root.val > max) return root.left==null?null: root.left;

		return root;
	}
	
	public static void Inorder(TreeNode root){
		if(root.left!=null) Inorder(root.left);
		System.out.println(root.val);
		if(root.right!=null) Inorder(root.right);
	}

	public static void main(String[] args){
		TreeNode n = new TreeNode(20);
		n.left = new TreeNode(10);
		n.left.left = new TreeNode(5);
		n.left.right = new TreeNode(15);

		n.right = new TreeNode(30);
		n.right.left = new TreeNode(25);
		n.right.right = new TreeNode(35);

		TreeNode res = RemoveOutsideRange(n,8,26);
		Inorder(res);
	}
}