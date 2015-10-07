// Lowest common ancestor with/without parent pointer

class LCA{
	//Without parent pointer   O(n) time
	public TreeNode GetLCA(TreeNode root, TreeNode n1, TreeNode n2){
		if(root == null) return null;
		if(root == n1 || root == n2) return root;

		TreeNode left = GetLCA(root.left,n1,n2);
		TreeNode right = GetLCA(root.right,n1,n2);

		if(left!=null && right!=null) return root;
		return left!=null？left:right;
	}

	//With parent pointer
	//Average case: O(logn)  worst case: O(n)
	public TreeNode GetLCA(TreeNode root, TreeNode n1, TreeNode n2){
		int depth1 = GetDep(n1,root);
		int depth2 = GetDep(n2,root);
		if(depth1>depth2){
			swap(depth1,depth2);
			swap(n1,n2);
		}
		for (int i = 0; i < depth1 - depth2; i++) {
			n2 = n2.parent;
		}

		while(n2!=null){
			if(n1==n2) return n1;
			n1 = n1.parent;
			n2 = n2.parent;
		}
		return null;
	}

	public int GetDep(TreeNode n,TreeNode root){
		if (root == null || n == null) return null;
		int dep = 0;
		while(n!=root){
			dep++;
			n = n.parent;
		}
		return dep;
	}

	public void Swap(Object<T> o1, Object<T> o2){
		Object<T> temp = o1;
		o1 = o2;
		o2 = temp;
	}
}