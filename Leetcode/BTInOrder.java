import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, HashTable, Stack
 */
class BTInOrder {
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
	    public List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> ret = new ArrayList<>();
	        if(root==null) return ret;
	        helper(root,ret);
	        return ret;
	    }
	    public void helper(TreeNode root,List<Integer> ret){
	        if(root==null) return;
	        helper(root.left,ret);
	        ret.add(root.val);
	        helper(root.right,ret);
	    }

	    //Iterative
	    /**
	     * Stack solution, O(n) Space
	     * Use a stack to store TreeNodes
	     * Go to left most and add each node
	     * Pop the node from stack, add its value, and try to go right
	     * Stop if stack is empty or node is null
	     */
	    public static List<Integer> inorderTraversal(TreeNode root) {
	    	List<Integer> res = new ArrayList<>();
	    	Stack<TreeNode> st = new Stack<>();

	    	while(!st.isEmpty() || root!=null){
	    		if(root!=null){
	    			st.push(root);
	    			root = root.left;
	    		}
	    		else{
	    			TreeNode node = st.pop();
	    			res.add(node.val);
	    			node = node.right;
	    		}
	    	}
	    	return res;
	    }
	}
}