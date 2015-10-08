

class KthLargestNodeInBST{
	static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;    
        TreeNode(int val){
            this.val = val;
        }
	}

	public static int kthLargest(TreeNode root, int k) {
        int count = helper(root.right); 
        if(k<=count) return kthLargest(root.right,k);
        else if(k>count+1) return kthLargest(root.left,k-count-1);
        return root.val;
    }
    
    public static int helper(TreeNode root){
        if(root == null) return 0;
        return 1+helper(root.left)+helper(root.right);
    }

    public static void main(String[] args){
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(25);
		System.out.println(kthLargest(root,3));
	}
}