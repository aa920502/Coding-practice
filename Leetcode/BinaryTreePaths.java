// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]

class BinaryTreePaths{
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if(root == null) return ret;
        helper("",root,ret);
        return ret;
    }
    public void helper(String tmp, TreeNode root, List<String> ret){
        tmp += root.val;
        if(root.left==null && root.right==null){
            ret.add(new String(tmp));
            return;
        }
        if(root.left!=null) helper(tmp+"->",root.left,ret);
        if(root.right!=null) helper(tmp+"->",root.right,ret);
    }
}