import java.util.*;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * 
 * Tags: Tree, Stack
 */
class BSTIterator {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	public class BSTIterator {
	    Stack<TreeNode> tmp;
	   
	    public BSTIterator(TreeNode root) {
	        tmp=new Stack<>();
	        addAll(root);
	    }
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !tmp.isEmpty();
	    }
	    /** @return the next smallest number */
	    public int next() {
	        if(tmp.isEmpty()) return -1;
	        TreeNode n = tmp.pop();
	        addAll(n.right);
	        return n.val;
	    }
	    //push all left nodes to stack
	    void addAll(TreeNode root) {
	        while (root != null) {
	            tmp.push(root);
	            root = root.left;
	        }
	    }
	}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

}