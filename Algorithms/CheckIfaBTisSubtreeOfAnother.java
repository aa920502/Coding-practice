// Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].
// Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].
// If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.


class CheckIfaBTisSubtreeOfAnother{
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val){
			this.val = val;
		}
	}	

	//Check if tree1 is subtree of tree2
	public static boolean Check(TreeNode n1, int size1, TreeNode n2, int size2){
		ArrayList<Integer> pre1 = preorderTraversal(n1);
		ArrayList<Integer> in1 = inorderTraversal(n1);
		
		ArrayList<Integer> pre2 = preorderTraversal(n2);
		ArrayList<Integer> in2 = inorderTraversal(n2);

		return (isSubArray(pre1,pre2) && isSubArray(in1,in2));
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
	    if(root==null) return ret;
	    Stack<TreeNode> st = new Stack<>();
	    st.push(root);
	    while(!st.isEmpty()){
	    	root = st.pop();
	    	ret.add(root.val);
	    	if(root.right!=null) st.push(root.right);
	    	if(root.left!=null) st.push(root.left);
	    }
	    return ret;
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root!=null){
        	if(root!=null){
        		st.push(root);
        		root=root.left;
        	}
			else{
				root = st.pop();
				ret.add(root.val);
				root=root.right;
			}
        }
        return ret;
    }

    public static boolean isSubArray(ArrayList<Integer> l1, ArrayList<Integer> l2){
    	int i1 = 0;
    	int i2 = 0;
    	while(i2<l2.size()){
    		if(l2.get(i2)==l1.get(i1)){
    			i1++;
    			i2++;
    			if(i1==l1.size()) return true;
    		}
    		else{
    			i2++;
    		}
    	}
    	return false;
    }

}