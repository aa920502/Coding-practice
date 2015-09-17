// invert a binary tree.

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1


class InvertBinaryTree{
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        if(root.left ==null&&root.right==null) return root;
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        if(root==null) return;
        if(root.left==null&&root.right==null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        helper(root.left);
        helper(root.right);
    }
}