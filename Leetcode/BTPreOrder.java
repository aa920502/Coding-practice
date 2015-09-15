import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, Stack
 */
class BTPreOrder {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
		//Recursive
	    public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> ret = new ArrayList<>();
		    if(root==null) return ret;
		    helper(root,ret);
		    return ret;
	    }
	    
	    public void helper(TreeNode root,List<Integer> ret){
	        if(root==null) return;
	        ret.add(root.val);
	        helper(root.left,ret);
	        helper(root.right,ret);
	    }

	    //Iterative
	    public List<Integer> preorderTraversal(TreeNode root) {
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

	}
}