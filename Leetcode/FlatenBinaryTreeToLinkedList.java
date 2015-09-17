/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child
 * points to the next node of a pre-order traversal.
 * 
 * Tags: Tree, DFS
 */
class FlatenBinaryTreeToLinkedList {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public void flatten(TreeNode root) {
        while(root!=null){
        	if(root.left!=null){
        		TreeNode n = root.left;
        		while(n.right!=null) n=n.right;
        		n.right = root.right; //append right subtree to right-most node in left subtree
        		root.right = root.left; // set root.right
        		root.left = null;  // clear root.left
        	}
        	root = root.right;
        }
    }
}