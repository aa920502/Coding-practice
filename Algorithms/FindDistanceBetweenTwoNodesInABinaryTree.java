// Find Distance between two nodes in a binary tree (LCA)


class FindDistanceBetweenTwoNodesInABinaryTree{
	public int getDistance(TreeNode root, TreeNode n1, TreeNode n2){
		int s1 = getDepth(root,n1);
		int s2 = getDepth(root,n2);
		TreeNode lca = getLCA(root,n1,n2);
		int s3 = getDepth(root,lca);
		return s1+s2-2*s3;
	}

	public int getDepth(TreeNode root, TreeNode n1) {
		if(root == null) return -1;
		if(root.val == n1.val) return 0;
		int left = getDepth(root.left,n1);
		int right = getDepth(root.right,n1);
		if(left==-1 && right == -1) return -1;
		return left==-1?right+1:left+1;
	}

	public TreeNode getLCA(TreeNode root,TreeNode n1, TreeNode n2){
		if(root == null || root == n1 || root == n2) return root;
		TreeNode left = getLCA(root.left,n1,n2);
		TreeNode right = getLCA(root.right,n1,n2);

		if(left!=null && right!=null) return root;
		return right==null?left:right;
	}

	public static void main(String[] args){
		FindDistanceBetweenTwoNodesInABinaryTree i = new FindDistanceBetweenTwoNodesInABinaryTree();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);
		root.left.right.right = new TreeNode(45);

		System.out.println(i.getDistance(root,root.left.left,root.left.right.right));
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