
// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].

// Note: Recursive solution is trivial, could you do it iteratively?


class BTPostOrder{
	// Recursive
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        helper(root,ret);
        return ret;
    }
    public void helper(TreeNode root,List<Integer> ret){
        if(root==null) return;
        helper(root.left,ret);
        helper(root.right,ret);
        ret.add(root.val);
    }

    //Iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur;
        TreeNode pre = null;

        st.push(root);
        while(!st.empty()){
        	cur = st.peek();
        	if((cur.left==null&&cur.right==null) || (pre!=null&& (pre==cur.left||pre==cur.right))){
        		ret.add(cur.val);
        		st.pop();
        		pre=cur;
        	}
        	else{
        		if(cur.right!=null) st.push(cur.right);
        		if(cur.left!=null) st.push(cur.left);
        	}
        }
        return ret;
    }
}