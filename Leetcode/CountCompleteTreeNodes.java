// Given a complete binary tree, count the number of nodes.

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, 
// and all nodes in the last level are as far left as possible. 
// It can have between 1 and 2h nodes inclusive at the last level h.

class CountCompleteTreeNodes{
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int leftDepth = leftHeight(root);
        int rightDepth = rightHeight(root);
        //Have a full tree here, just return
        if(leftDepth == rightDepth) 
            return (1<<leftDepth) -1;
        //Not a full tree
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    public int leftHeight(TreeNode root){
        int dep = 0;
        while(root!=null){
            root = root.left;
            dep++;
        }
        return dep;
    }
    
    public int rightHeight(TreeNode root){
        int dep = 0;
        while(root!=null){
            root = root.right;
            dep++;
        }
        return dep;
    }
}